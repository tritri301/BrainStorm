package View;

import Controllers.CommandeController;
import Controllers.ItemCommandeController;
import Controllers.ItemController;
import Controllers.ItemInfoController;
import Models.Commande;
import Models.Item;
import Models.ItemCommande;
import Models.ItemInfo;
import Services.ItemInfoService;
import javafx.scene.control.Dialog;
import Services.ItemService;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

public class Browser extends BorderPane {
    private static final View.Browser instance = new View.Browser();
    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();
    private JSObject window = (JSObject) webEngine.executeScript("window");
    private JavaApp javaApp;

    //Browser constructor
    public Browser() {
        //add components
        setCenter(browser);
       javaApp = new JavaApp();

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
        webEngine.load("file:///" + System.getProperty("user.dir") + "/Interface/index.html");
    }

    //Signleton function
    public static View.Browser GetInstance() {
        return instance;
    }


    //JavaScript caller object
    public void Alert(String msg) {
        window.call("Alert", msg);
    }


    // JavaScript interface object
    public class JavaApp {
        public void exit() {
            Platform.exit();
        }

        public void ListAllItem() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
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

        public void ListAllItemRapport() {
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

        public void ecrireFichier() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            try {
                FileWriter writer = new FileWriter("C:\\MyFile.txt", true);
                for (int i = 0; i < itemList.size(); i++) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    writer.write(itemList.get(i).getIdItem());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public void ListItemById(int id) {
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
        public void ListDeleteItemByUPC(int upc)
        {
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
        public void ListDeleteItemByContainer(String emplacement)
        {
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
            ItemController itemController = ItemController.GetInstance();

            if(itemController.ModifyItem(id,description))
            {
                Alert("Objet modifié avec succes");
                return true;
            }
            return false;
        }

        //--------------------MODULE COMMANDE---------------------------------------

        //Cette fonction créer une commande et une commandeItem avec les paramètres reçus en javascrpt
        //CommandeItem est une table d'item commandé pour commande
        public boolean CreateCommande(int upc,int quantite,String description)
        {
            boolean valide = false;
            int id;
            //Aller chercher dans UserController le nom User en cours
            String nomPEnvoi = "AnnonymeQuiEnvoi";

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
            //Aller chercher dans UserController le nom User en cours
            String nomPRecu = "AnnonymeQuiRecoit";
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
                                        commande.getEtat());
                            }
                        }
                    }
                }
            }
        }
    }
}
