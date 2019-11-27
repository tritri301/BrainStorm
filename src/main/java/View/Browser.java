package View;

import Controllers.ItemController;
import Controllers.ItemInfoController;
import Controllers.RoleController;
import Controllers.UserController;
import Factory.UserFactory;
import Models.*;
import Services.HashService;
import javafx.scene.control.Dialog;
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
import java.util.List;

public class Browser extends BorderPane {
    private static final View.Browser instance = new View.Browser();
    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();
    private JSObject window = (JSObject) webEngine.executeScript("window");
    private JavaApp javaApp;

    //Browser constructor
    public Browser() {
        javaApp = new JavaApp();
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
        public void FindUserById(int id)
        {
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
        public void ModifyUser(int numEmpl, String email, String password, String Poste, String lastName, String firstName, String adresse, int idRole)
        {
            UserFactory userFactory = UserFactory.GetInstance();
            UserController userController = UserController.GetInstance();
            User userToUpdate = userFactory.Create(numEmpl, email, password, Poste, lastName, firstName, adresse, idRole);
            if(userController.Update(userToUpdate))
            {
                Alert("User modified successfully!");
            }
            else
            {
                Alert("There was a problem modifying this user!");
            }
        }
        public void CreateUser(int numEmpl, String email, String password, String Poste, String lastName, String firstName, String adresse, int idRole)
        {
            UserController userController = UserController.GetInstance();
            if(userController.Create(numEmpl, email, password, Poste, lastName, firstName, adresse, idRole))
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
            ConnectedUser connectedUser = ConnectedUser.GetInstance();
            UserFactory userFactory = UserFactory.GetInstance();
            HashService hashService = HashService.getInstance();
            UserController userController = UserController.GetInstance();

            List<User> userToConnect = userController.FindByEmail(user);
            if(userToConnect == null)
            {
                return false;
            }
            if(userToConnect.get(0).getPassword().equals(hashService.HashString(password)))
            {
                connectedUser = userFactory.CreateConnected(userToConnect.get(0));
                return true;
            }
            connectedUser = null;
            return false;
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

        public boolean ModifyItem(int id, String description) {
            ItemController itemController = ItemController.GetInstance();

            if (itemController.ModifyItem(id, description)) {
                Alert("Objet modifié avec succes");
                return true;
            }
            return false;
        }

    }
}
