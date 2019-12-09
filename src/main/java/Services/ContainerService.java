package Services;

import Exception.ExceptionCustom;
import Factory.ContainerFactory;
import Models.ConnectionBD;
import Models.Container;
import Repositories.ContainerRepository;
import Services.Interfaces.ContainerServiceInterface;

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

    /**
     * Get instance container service.
     *
     * @return the container service
     */
    public static ContainerService GetInstance() {
        return instance;
    }

    @Override
    public Container FindById(String emplacement) throws ExceptionCustom {
        Container container = null;
        emplacement = this.verificationService.normalisation(emplacement);

        if (connection == null) {
            try {
                container = this.containerRepository.FindById("test");
            } catch (Exception e) {
                e.printStackTrace();
                throw new ExceptionCustom("cette position est introuvable");
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }
        return container;
    }

    @Override
    public List<Container> FindAll() throws ExceptionCustom {
        List<Container> container = new ArrayList<Container>();
        if (connection == null) {
            try {
                container = this.containerRepository.FindAll();
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd" + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return new ArrayList<>();
    }

    @Override
    public boolean Update(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) throws ExceptionCustom {

        boolean valide = false;
        emplacement = this.verificationService.normalisation(emplacement);
        emplacementParent = this.verificationService.normalisation(emplacementParent);

        //TODO verifier limite du container
        if (this.verificationService.verifier(emplacement) && this.verificationService.verifier(volume, volumeMax, poids, poidsMax)) {
            Container nouveauContainer = FindById(emplacement);
            nouveauContainer.setEmplacement(emplacement);
            nouveauContainer.setVolume(volume);
            nouveauContainer.setVolumeMax(volumeMax);
            nouveauContainer.setPoids(poids);
            nouveauContainer.setPoidsMax(poidsMax);
            nouveauContainer.setEmplacementParent(emplacementParent);
            valide = true;
            if (connection == null) {
                try {
                    this.containerRepository.Update(nouveauContainer);
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("Erreur de bd" + e.toString());
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
        }
        return valide;
    }

    @Override
    public boolean Create(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(volume, volumeMax, poids, poidsMax);
        emplacement = this.verificationService.normalisation(emplacement);
        emplacementParent = this.verificationService.normalisation(emplacementParent);

        //TODO verifier limite du container

        if (valide) {
            if (connection == null) {
                try {
                    containerRepository.Create(this.containerFactory.Create(emplacement, volume, volumeMax, poids, poidsMax, emplacementParent));
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("Erreur de bd" + e.toString());
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return valide;
    }

    @Override
    public boolean Delete(String emplacement) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(emplacement);

        if (valide) {
            if (connection == null) {
                try {
                    this.containerRepository.Delete(emplacement);
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("cette position est introuvable");
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return valide;
    }
}
