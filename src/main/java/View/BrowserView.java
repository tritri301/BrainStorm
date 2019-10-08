package View;

import Controllers.ItemController;
import Controllers.ItemInfoController;
import Models.Item;
import Repositories.ContainerRepository;
import Repositories.ItemInfoRepository;
import Repositories.ItemRepository;
import Repositories.UserRepository;
import Services.ItemInfoService;
import Services.ItemService;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import netscape.javascript.JSObject;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

public class BrowserView extends Application{
    private Scene scene;

    @Override
    public void start(Stage stage){

        // create scene

        //Tentative d'ajout d'un icône
        stage.setTitle("Cool Play Inc");
        Image icone = new Image ("file:icone.png");
        stage.getIcons().add(icone);

        scene = new Scene(Browser.GetInstance(),Color.BLACK);

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Browser extends BorderPane {
    private static final Browser instance = new Browser();
    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();
    private JSObject window = (JSObject) webEngine.executeScript("window");

    //Browser constructor
    public Browser() {


        //add components
        setCenter(browser);

        //add listenners
        webEngine.getLoadWorker().stateProperty().addListener(
        new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != Worker.State.SUCCEEDED) { return; }

                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("JavaApp", new JavaApp());
            }
        });
        webEngine.setOnAlert(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(event.getData());
            alert.showAndWait();
        });

        // load the home page
        webEngine.load("file:///" + System.getProperty("user.dir") + "/Interface/index.html");
    }
    //Signleton function
    public static Browser GetInstance(){
        return instance;
    }


    //JavaScript caller object
    public void Alert()
    {
        window.call("Alert","wow it might work");
    }
    public void ListItems()
    {
        ItemInfoController itemInfoController = ItemInfoController.GetInstance();
        ItemController itemController = ItemController.GetInstance();
        List<Item> itemList = itemController.FindAll();
        for(int i = 0; i < itemList.size(); i++)
        {
            window.call("ShowItem", itemList.get(i).getIdItem(),
                    itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getNom(),
                    itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getDescription(),
                    itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getPoids(),
                    itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getVolume());
        }
    }
    public void ListItems(int id)
    {
        ItemInfoController itemInfoController = ItemInfoController.GetInstance();
        ItemController itemController = ItemController.GetInstance();
        Item item = itemController.FindById(id);
        window.call("ShowItem", item.getIdItem(),
                itemInfoController.FindById(item.getIdItemInfo()).getNom(),
                itemInfoController.FindById(item.getIdItemInfo()).getDescription(),
                itemInfoController.FindById(item.getIdItemInfo()).getPoids(),
                itemInfoController.FindById(item.getIdItemInfo()).getVolume());

    }




    // JavaScript interface object
    public class JavaApp {
        public void exit() {
            Platform.exit();
        }

    }
}
