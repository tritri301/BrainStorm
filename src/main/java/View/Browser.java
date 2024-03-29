package View;

import Controllers.*;
import Factory.UserFactory;
import Models.*;
import Repositories.BackupRepository;
import Services.HashService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Browser extends BorderPane {
    private static final View.Browser instance = new View.Browser();
    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();
    private JSObject window = (JSObject) webEngine.executeScript("window");
    private JavaApp javaApp = new JavaApp();

    //Browser constructor
    public Browser() {
        //add components
        setCenter(browser);

        //add listenners
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (newValue != Worker.State.SUCCEEDED) {
                            return;
                        }
                        JSObject window = (JSObject) webEngine.executeScript("window");
                        window.setMember("JavaApp", javaApp);
                        window.call("CheckPermission");
                        if(webEngine.getLocation().equals("file:///" + System.getProperty("user.dir") + "/Interface/rapport.html"))
                        {
                            window.call("showListFolder");
                        }
                    }
                });

        webEngine.setOnAlert(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(event.getData());
            alert.showAndWait();
        });
        webEngine.setConfirmHandler(message -> {
            Dialog<ButtonType> confirm = new Dialog<>();
            confirm.getDialogPane().setContentText(message);
            confirm.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
            boolean result = confirm.showAndWait().filter(ButtonType.YES::equals).isPresent();

            return result ;
        });
        // load the home page
        webEngine.load("file:///" + System.getProperty("user.dir") + "/Interface/connexion.html");
    }

    //Signleton function
    public static View.Browser GetInstance() {
        return instance;
    }


    //JavaScript caller object
    public void Alert(String msg) {
        window.call("Alert", msg);
    }


    public class JavaApp {
        public void createBackup()
        {
            BackupRepository backupRepository = new BackupRepository();
            Alert("La création du backup peut prendre quelque minutes..");
            backupRepository.create();
            Alert("Backup créé avec succes!");
        }
        public void ShowBackups()
        {
            BackupRepository backupRepository = new BackupRepository();
            Alert("Récupération de la liste de backup.. Ceci peut prendre un certain temps..");
            List<String> backups = backupRepository.FindAll();
            window.call("clearBackups");
            for(int i = 0; i < backups.size(); i++)
            {
                window.call("ShowBackups", backups.get(i), i);
            }
        }
        public void Restore(int index)
        {
            BackupRepository backupRepository = new BackupRepository();
            String backupName = backupRepository.FindAll().get(index);
            backupRepository.restore(backupName);
            Alert("restauré avec succes!");
        }
        public boolean isUserConnected()
        {
            ConnectedUser user = ConnectedUser.GetInstance();

            if(user.getLastConnected() != null)
            {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime lastConnected = LocalDateTime.parse(user.getLastConnected(), format);
                now.format(format);
                return lastConnected.plusHours(3).isBefore(now);
            }
            return false;
        }
        public void FindUserById(int id)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            UserController userController = UserController.GetInstance();

            User user = userController.FindById(id);
            if(user != null)
            {
                window.call("ShowUser",
                        user.getEmail(),
                        user.getPassword(),
                        user.getPoste(),
                        user.getLastName(),
                        user.getFirstName(),
                        user.getAdresse(),
                        user.getIdRole());
            }
        }
        public void ModifyUser(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            UserFactory userFactory = UserFactory.GetInstance();
            UserController userController = UserController.GetInstance();
            User userToUpdate = userFactory.Create(idUser, email, password, poste, lastName, firstName, adresse, null, null, 0, idRole);
            if(userController.Update(userToUpdate))
            {
                Alert("User modified successfully!");
            }
            else
            {
                Alert("There was a problem modifying this user!");
            }
        }
        public void CreateUser(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            UserController userController = UserController.GetInstance();
            if(userController.Create(idUser, email, password, poste, lastName, firstName, adresse, null, null, 0, idRole))
            {
                Alert("User created successfully!");
            }
            else
            {
                Alert("There was a problem creating this user!");
            }
        }

        public boolean CheckConnexion(String user, String password)
        {
            UserFactory userFactory = UserFactory.GetInstance();
            HashService hashService = HashService.getInstance();
            UserController userController = UserController.GetInstance();

            return userController.ConnectUser(user, password);
        }

        public String CheckPermission()
        {

            RoleController roleController = RoleController.getInstance();
            ConnectedUser connectedUser = ConnectedUser.GetInstance();

            int idRole = connectedUser.getIdRole();
            Role role = roleController.FindById(idRole);
            if(role != null) //if no permission is found for a user, remove all rights to the app
                return roleController.FindById(idRole).getPermissions();
            else
                return "00000000000000000000000000000000000000000000000";
        }

        public void exit() {
            Platform.exit();
        }

        public void ListAllItem() {
            browser.getEngine().load("javascript:window.location.reload( true )");

            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowItem", tmp.getIdItemInfo(),
                        tmp.getNom(),
                        tmp.getDescription(),
                        itemList.get(i).getEmplacement(),
                        tmp.getPoids(),
                        tmp.getVolume(),
                        itemList.get(i).getQuantite());
            }
        }

        public void ListAllItemRapport() {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowItemRapport", tmp.getIdItemInfo(),
                        tmp.getNom(),
                        itemList.get(i).getEmplacement(),
                        tmp.getPoids(),
                        tmp.getVolume(),
                        itemList.get(i).getQuantite());
            }
        }

        public void ListItemById(int id) {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            Item item = itemController.FindById(id);
            ItemInfo tmp = itemInfoController.FindById(item.getIdItemInfo());
            window.call("ShowItem", tmp.getIdItemInfo(),
                    tmp.getNom(),
                    item.getEmplacement(),
                    tmp.getPoids(),
                    tmp.getVolume(),
                    item.getQuantite());
        }

        public void ListItemByName(String name) {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindByName(name);
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowItem", tmp.getIdItemInfo(),
                        tmp.getNom(),
                        itemList.get(i).getEmplacement(),
                        tmp.getPoids(),
                        tmp.getVolume(),
                        itemList.get(i).getQuantite());
            }
        }

        public void ListDeleteItemByUPC(int upc) {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                //If the upc is correct
                if(itemList.get(i).getIdItemInfo() == upc) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    window.call("ShowDeleteItem",
                            tmp.getIdItemInfo(),
                            tmp.getNom(),
                            tmp.getDescription(),
                            itemList.get(i).getEmplacement(),
                            itemList.get(i).getQuantite(),
                            itemList.get(i).getIdItem());
                }
            }
        }

        public void ListUpdateItemByUPC(int upc) {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                //If the upc is correct
                if(itemList.get(i).getIdItemInfo() == upc) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    window.call("ShowUpdateItem",
                            tmp.getIdItemInfo(),
                            tmp.getNom(),
                            tmp.getDescription(),
                            itemList.get(i).getEmplacement(),
                            itemList.get(i).getQuantite(),
                            itemList.get(i).getIdItem());
                }
            }
        }

        public void ListUpdateItemByDesc(String desc) {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                //If the description is correct

                if(itemList.get(i).getDescription().equals(desc)) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    window.call("ShowUpdateItem",
                            tmp.getIdItemInfo(),
                            tmp.getNom(),
                            itemList.get(i).getDescription(),
                            itemList.get(i).getEmplacement(),
                            itemList.get(i).getQuantite(),
                            itemList.get(i).getIdItem());
                }
            }
        }


        public void ListAllUpdateItem()
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowUpdateItem",
                        tmp.getIdItemInfo(),
                        tmp.getNom(),
                        tmp.getDescription(),
                        itemList.get(i).getEmplacement(),
                        itemList.get(i).getQuantite(),
                        itemList.get(i).getIdItem());
            }
        }
        public void ListDeleteItemByContainer(String emplacement)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                //If the upc is correct
                if(itemList.get(i).getEmplacement().equals(emplacement)) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    window.call("ShowDeleteItem",
                            tmp.getIdItemInfo(),
                            tmp.getNom(),
                            tmp.getDescription(),
                            itemList.get(i).getEmplacement(),
                            itemList.get(i).getQuantite(),
                            itemList.get(i).getIdItem());
                }
            }
        }
        public void ListAllDeleteItem()
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowDeleteItem",
                        tmp.getIdItemInfo(),
                        tmp.getNom(),
                        tmp.getDescription(),
                        itemList.get(i).getEmplacement(),
                        itemList.get(i).getQuantite(),
                        itemList.get(i).getIdItem());
            }
        }
        public boolean DeleteItem(int id, int quantite)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            if(itemController.Delete(id, quantite))
            {
                Alert("Objet retiré avec succes");
                return true;
            }
            return false;
        }

        public boolean CreateItem(int upc,String emplacement, String description, int quantite)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            if(itemController.Create(upc,emplacement, description, quantite))
            {
                Alert("Objet ajouté avec succes");
                return true;
            }
            return false;
        }


        public boolean MoveItem(int id,int quantite,String emplacementNouveau)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();

            if(itemController.MoveItem(id,quantite,emplacementNouveau))
            {
                Alert("Objet déplacé avec succes");
                return true;
            }
            return false;
        }

        public boolean ModifyItem(int id, String description)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();

            if(itemController.ModifyItem(id,description))
            {
                Alert("Objet modifié avec succes");
                return true;
            }
            return false;
        }
        public void CreateCSVFile() {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            List<ItemInfo> itemInfoList = itemInfoController.FindAll();

            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");

            String dateString = date.format(new Date());
            try {
                File file = new File("Rapport\\" + dateString + ".csv");
                file.getParentFile().mkdirs();
                PrintWriter writer = new PrintWriter(file);
                StringBuffer csvHeader = new StringBuffer("");
                StringBuffer csvData = new StringBuffer("");
                csvHeader.append("Id,Nom,Emplacement,Poids,Volume,Quantite\n");

                // write header
                writer.write(csvHeader.toString());

                for (int i = 0; i < itemList.size(); i++) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    csvData.append(tmp.getIdItemInfo());
                    csvData.append(',');
                    csvData.append(tmp.getNom());
                    csvData.append(',');
                    csvData.append(itemList.get(i).getEmplacement());
                    csvData.append(',');
                    csvData.append(tmp.getPoids());
                    csvData.append(',');
                    csvData.append(tmp.getVolume());
                    csvData.append(',');
                    csvData.append(itemList.get(i).getQuantite());
                    csvData.append('\n');
                    writer.write(csvData.toString());
                }
                writer.close();
                Alert("Fichier CSV générer avec succès");
            } catch (IOException e) {
                e.printStackTrace();
                Alert("Une erreur c'est produite lors de la création du fichier CSV, contacter votre administrateur réseau");
            }
        }

        public void CreateExcelFile() {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            List<ItemInfo> itemInfoList = itemInfoController.FindAll();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");

            String dateString = date.format(new Date());
            try {
                String filename = "Rapport\\" + dateString + ".xls" ;
                File file = new File(filename);
                file.getParentFile().mkdirs();
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("Rapport");

                HSSFRow rowhead = sheet.createRow((short)0);
                rowhead.createCell(0).setCellValue("Id");
                rowhead.createCell(1).setCellValue("Nom");
                rowhead.createCell(2).setCellValue("Emplacement");
                rowhead.createCell(3).setCellValue("Poids");
                rowhead.createCell(4).setCellValue("Volume");
                rowhead.createCell(5).setCellValue("Quantité");

                int cpt = 1;
                for (int i = 0; i < itemList.size(); i++) {
                    HSSFRow row = sheet.createRow((short)cpt);
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    row.createCell(0).setCellValue(tmp.getIdItemInfo());
                    row.createCell(1).setCellValue(tmp.getNom());
                    row.createCell(2).setCellValue(itemList.get(i).getEmplacement());
                    row.createCell(3).setCellValue(tmp.getPoids());
                    row.createCell(4).setCellValue(tmp.getVolume());
                    row.createCell(5).setCellValue(itemList.get(i).getQuantite());
                    cpt++;
                }

                FileOutputStream fileOut = new FileOutputStream(filename);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                Alert("Fichier Excel générer avec succès");

            } catch ( Exception ex ) {
                Alert("Une erreur c'est produite lors de la création du fichier Excel, contacter votre administrateur réseau");
                //System.out.println(ex);
            }
        }

        public void ShowRapportInterface(String tri) {
            browser.getEngine().load("javascript:window.location.reload( true )");
            File f = new File("Rapport\\"); // current directory

            File[] files = f.listFiles();
            if (tri.equals("ascendant")) Arrays.sort(files);
            else if (tri.equals("descendant"))Arrays.sort(files, Collections.reverseOrder());

            for (File file : files) {
                if (file.isDirectory()) {
                    //System.out.print("directory:");
                } else {
                    //System.out.print("     file:");
                }
                try {
                    window.call("createTable",file.getCanonicalPath());
                    String nameFile=file.getCanonicalPath();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //--------------------MODULE COMMANDE---------------------------------------

        //Cette fonction créer une commande et une commandeItem avec les paramètres reçus en javascrpt
        //CommandeItem est une table d'item commandé pour commande
        public boolean CreateCommande(int upc,int quantite,String description)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ConnectedUser connectedUser = ConnectedUser.GetInstance();

            boolean valide = false;
            int id;

            //Aller chercher dans connectedUser le nom d'utilisateur en cours
            String nomPEnvoi = connectedUser.getFirstName()+" "+connectedUser.getLastName();

            CommandeController commandeController = CommandeController.GetInstance();
            ItemCommandeController itemCommandeController = ItemCommandeController.GetInstance();

            //La fonction create de commande retourne l'id de son insertion
            id = commandeController.Create(nomPEnvoi);

            //premier parametre a 0 car il sera ignoré
            if (itemCommandeController.Create(0,id,upc,description,quantite))
            {
                valide = true;
                Alert("Commande ajouté avec succes");
            }

            return valide;
        }

        //Cette fonction update une commande et crée un item avec les paramètres reçus en javascrpt
        public boolean RecevoirCommande(int idItemCommande,String emplacement)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            ConnectedUser connectedUser = ConnectedUser.GetInstance();
            //Aller chercher dans connectedUser le nom d'utilisateur en cours
            String nomPRecu = connectedUser.getFirstName()+" "+connectedUser.getLastName();
            CommandeController commandeController = CommandeController.GetInstance();
            ItemController itemController = ItemController.GetInstance();
            ItemCommandeController itemCommandeController = ItemCommandeController.GetInstance();

            ItemCommande itemCommande = itemCommandeController.FindById(idItemCommande);
            Commande commande = commandeController.FindById(itemCommande.getIdCommande());

            if(commandeController.Update(commande.getIdCommande(),2,nomPRecu))
            {
                if (itemController.Create(itemCommande.getIdItemInfo(),emplacement,itemCommande.getDescription(), itemCommande.getQuantite()))
                {
                    Alert("Commande recu avec succes");
                    return true;
                }
            }

            return false;
        }

        //Cette fonction retourne les données recherchées à la fonction JavaSripts ShowItem
        public void ListAllCommande(int upc,String name,int etat,boolean retard)
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            java.sql.Date dateNow = new java.sql.Date(Calendar.getInstance().getTime().getTime());

            CommandeController commandeController = CommandeController.GetInstance();
            ItemCommandeController itemCommandeController = ItemCommandeController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            ItemController itemController = ItemController.GetInstance();
            List<ItemCommande> itemCommandeList = itemCommandeController.FindAll();

            for (ItemCommande itemCommandeTmp : itemCommandeList) {
                ItemInfo itemInfoTmp = itemInfoController.FindById(itemCommandeTmp.getIdItemInfo());
                Commande commande = commandeController.FindById(itemCommandeTmp.getIdCommande());
                if (itemCommandeTmp.getIdItemInfo() == upc || upc == -1) {
                    if (itemInfoTmp.getNom().equals(name) || name.equals("-1")) {
                        if (commande.getEtat() == etat || etat == -1) {
                            if (commande.getDateLivraisonPrevu().before(dateNow) || !retard) {
                                window.call("ShowCommandeItem",
                                        itemCommandeTmp.getIdItemCommande(),
                                        itemInfoTmp.getNom(),
                                        itemCommandeTmp.getDescription(),
                                        itemCommandeTmp.getQuantite(),
                                        commande.getDateLivraisonPrevu(),
                                        commande.getEtat(),
                                        commande.getNomPEnvoi(),
                                        commande.getNomPRecu());
                            }
                        }
                    }
                }
            }
        }
        public void ShowBackupMenu()
        {
            browser.getEngine().load("javascript:window.location.reload( true )");
            BackupController backupController = BackupController.GetInstance();

            backupController.ShowBackupMenu();

                Alert("Objet modifié avec succes");
        }

    }
}
