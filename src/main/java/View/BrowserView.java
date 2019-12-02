package View;

import Controllers.*;
import Factory.*;
import Models.Item;
import Repositories.*;
import Services.*;
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
        ItemController itemController = ItemController.GetInstance();
        ItemInfoController itemInfoController = ItemInfoController.GetInstance();
        ContainerController containerController = ContainerController.GetInstance();
        UserController userController = UserController.GetInstance();
        CommandeController commandeController = CommandeController.GetInstance();


        ContainerFactory containerFactory = ContainerFactory.GetInstance();
        ItemFactory itemFactory = ItemFactory.GetInstance();
        ItemInfoFactory itemInfoFactory = ItemInfoFactory.GetInstance();
        UserFactory userFactory = UserFactory.GetInstance();
        CommandeFactory commandeFactory = CommandeFactory.GetInstance();

        ContainerRepository containerRepository = ContainerRepository.GetInstance();
        ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();
        ItemRepository itemRepository = ItemRepository.GetInstance();
        UserRepository userRepository = UserRepository.GetInstance();
        CommandeRepository commandeRepository = CommandeRepository.GetInstance();

        ContainerService containerService = ContainerService.GetInstance();
        ItemInfoService itemInfoService = ItemInfoService.GetInstance();
        ItemService itemService = ItemService.GetInstance();
        UserService userService = UserService.GetInstance();
        VerificationService verificationService = VerificationService.GetInstance();
        CommandeService commandeService = CommandeService.GetInstance();

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
