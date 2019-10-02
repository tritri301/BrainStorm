package Services;

import Factory.ContainerFactory;
import Models.ConnectionBD;
import Repositories.ContainerRepository;
import Services.Interfaces.ContainerServiceInterface;
import Models.Container;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Container service.
 */
public class ContainerService implements ContainerServiceInterface {

    private static final ContainerService instance = new ContainerService();
    private ContainerRepository containerRepository = ContainerRepository.GetInstance();
    private ContainerFactory containerFactory = ContainerFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();


    @Override
    public Container FindById(int id) throws ExceptionCustom {
        Container container = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    container = this.containerRepository.FindById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }
        else{
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
            }

        return container;
    }

    @Override
    public List<Container> FindAll() {
        List<Container> container = new ArrayList<Container>();
        if (connection == null)
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

    /**
    @Override
    public List<Container> FindByName(String name) {

        //verification

        List<Container> container = new ArrayList<Container>();
        if (connection == null)
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
    **/

    @Override
    public boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idContainer,quantite,position,volume,poidsMax,containerParent);

        if (valide) {
            Container nouveauContainer = FindById(idContainer);
            nouveauContainer.setQuantite(quantite);
            nouveauContainer.setPosition(position);
            nouveauContainer.setVolume(volume);
            nouveauContainer.setPoidsMax(poidsMax);
            nouveauContainer.setIdContainerParent(containerParent);

            if (connection == null) {
                try {
                    this.containerRepository.Update(nouveauContainer);
                } catch (Exception e) {
                    valide = false;
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }
        else{
            //donnée entré non valide
        }

        return valide;
    }

    @Override
    public boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {

        boolean valide = this.verificationService.verifier(idContainer,quantite,position,volume,poidsMax,containerParent);

        if (valide) {
            if (connection == null) {
                try {
                    containerRepository.Create(this.containerFactory.Create(idContainer, quantite, position, volume, poidsMax, containerParent));
                } catch (Exception e) {
                    valide = false;
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }
        else{
            //donnée entré non valide
        }

        return valide;
    }

    @Override
    public boolean Delete(int id) {
        boolean valide = this.verificationService.verifier(id);

        if (valide) {
            if (connection == null) {
                try {
                    this.containerRepository.Delete(id);
                } catch (Exception e) {
                    valide = false;
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }else{
            //donnée entré non valide
        }

        return valide;
    }

    /**
     * Get instance container service.
     *
     * @return the container service
     */
    public static ContainerService GetInstance()
    {
        return instance;
    }
}
