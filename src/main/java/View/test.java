package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.awt.Dimension;

public class test extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start (Stage stage) throws Exception{
        WebView myWebView = new WebView();
        WebEngine engine = myWebView.getEngine();
        engine.load("file:///C:/Users/cout840400/IdeaProjects/BrainStorm_Inventaire/Interface/index.html");
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth()-10;
        double height = screenSize.getHeight()-100;

        VBox root = new VBox();
        root.getChildren().addAll(myWebView);

        Scene scene = new Scene(root,width,height);
        stage.setScene(scene);
        stage.setMaximized(true);
        //stage.setFullScreen(true);


        stage.show();
    }
}
