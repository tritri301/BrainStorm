package View;

import javafx.application.Application;
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
import netscape.javascript.JSObject;

public class test extends Application{
    private Scene scene;

    @Override
    public void start(Stage stage) {

        // create scene
        stage.setTitle("Web View");
        scene = new Scene(new Browser(),Color.BLACK);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Browser extends BorderPane {

    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();



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

        // load the home page
        webEngine.load("file:///" + System.getProperty("user.dir") + "/Interface/index.html");
    }
    // JavaScript interface object
    public class JavaApp {
        public void exit() {
            Platform.exit();
        }
    }
}
