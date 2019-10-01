package Services;

import Factory.ContainerFactory;
import Models.ConnectionBD;
import Repositories.ContainerRepository;
import Services.Interfaces.ContainerServiceInterface;
import Models.Container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Container service.
 */
public class ContainerService implements ContainerServiceInterface {

    private static final ContainerService instance = new ContainerService();
    private ContainerRepository containerRepository = ContainerRepository.GetInstance();
    private ContainerFactory containerFactory = ContainerFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();

    @Override
    public Container FindById(int id) {
        Container container = null;
        if (connectionBD == null)
        {
            try {
                container = this.containerRepository.FindById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return container;
    }

    @Override
    public List<Container> FindAll() {
        List<Container> container = new ArrayList<Container>();
        if (connectionBD == null)
        {
            try {
              //  container = this.containerRepository.FindAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return new ArrayList<>();
    }

    @Override
    public Container FindByName(String name) {
        return null;
    }

    @Override
    public Container Update(int id) {
        return null;
    }

    @Override
    public Container Create() {
        return null;
    }

    @Override
    public Container Delete(int id) {
        return null;
    }

    public static ContainerService GetInstance()
    {
        return instance;
    }
}
