package Controllers;

import Controllers.Interface.ContainerControllerInterface;
import Controllers.Interface.ItemControllerInterface;
import Models.Container;
import Models.Item;
import Services.ItemService;

import java.util.List;
import Exception.*;


/**
 * The type Container controller.
 */
public class ContainerController implements ContainerControllerInterface {

    private static final ContainerController instance = new ContainerController();

    @Override
    public Container FindById(int id) {
        return null;
    }

    @Override
    public List<Container> FindAll() {
        return null;
    }

    @Override
    public boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        return false;
    }

    @Override
    public boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        return false;
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }

    /**
     * Get instance container controller.
     *
     * @return the container controller
     */
    public static ContainerController GetInstance()
    {
        return instance;
    }
}
