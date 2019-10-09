package View;

import Controllers.ItemController;
import Controllers.ItemInfoController;
import Models.Item;
import Services.ItemService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.util.List;

public class Browser extends BorderPane {
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
                        if (newValue != Worker.State.SUCCEEDED) {
                            return;
                        }

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
    public static Browser GetInstance() {
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

        public void ListItem() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                window.call("ShowItem", itemList.get(i).getIdItem(),
                        itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getNom(),
                        itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getDescription(),
                        itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getPoids(),
                        itemInfoController.FindById(itemList.get(i).getIdItemInfo()).getVolume());
            }
        }
    }
}
