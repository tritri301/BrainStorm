package Controllers;

import Controllers.Interface.ContainerControllerInterface;
import Models.Container;

import java.util.List;

/**
 * @Note le container controller n'est pas coder car il n'est pas nécessaire
 */
public class ContainerController implements ContainerControllerInterface {

    private static final ContainerController instance = new ContainerController();

    @Deprecated
    public Container FindById(int id) {
        return null;
    }

    @Deprecated
    public List<Container> FindAll() {
        return null;
    }

    @Override
    public boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        return false;
    }

    @Deprecated
    public boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        return false;
    }

    @Deprecated
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
