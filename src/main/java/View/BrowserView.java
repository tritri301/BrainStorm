package View;

import Controllers.*;
import Factory.*;
import Models.ConnectedUser;
import Repositories.*;
import Services.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The type Browser view.
 */
public class BrowserView extends Application{

    @Override
    public void start(Stage stage){

        // create scene

        //Tentative d'ajout d'un icône
        stage.setTitle("Cool Play Inc");
        Image icone = new Image ("file:icone.png");
        stage.getIcons().add(icone);

        Scene scene = new Scene(Browser.GetInstance(), Color.BLACK);
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

        RoleController roleController = RoleController.getInstance();
        ConnectedUser connectedUser = ConnectedUser.GetInstance();

        CommandeService commandeService = CommandeService.GetInstance();

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
