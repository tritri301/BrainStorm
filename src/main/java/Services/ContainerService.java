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

        //verification

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
    public List<Container> FindByName(String name) {

        //verification

        List<Container> container = new ArrayList<Container>();
        if (connectionBD.GetConnectionStatus() == null)
        {
            try {
                container = this.containerRepository.FindByName(name);
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
    public boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        boolean valide = true;

        //verification

        Container nouveauContainer = FindById(idContainer);
        nouveauContainer.setQuantite(quantite);
        nouveauContainer.setPosition(position);
        nouveauContainer.setVolume(volume);
        nouveauContainer.setPoidsMax(poidsMax);
        nouveauContainer.setIdContainerParent(containerParent);

        if (connectionBD == null)
        {
            try {
                this.containerRepository.Update(nouveauContainer);
            } catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    @Override
    public boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        boolean valide = true;

        //verification

        if (connectionBD == null)
        {
            try {
                containerRepository.Create(this.containerFactory.Create(idContainer,quantite,position,volume,poidsMax,containerParent));
            }catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    @Override
    public boolean Delete(int id) {
        boolean valide = true;

        //verification

        if (connectionBD == null)
        {
            try {
                this.containerRepository.Delete(id);
            } catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    public static ContainerService GetInstance()
    {
        return instance;
    }
}
