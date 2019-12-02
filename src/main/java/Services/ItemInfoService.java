package Services;

import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Repositories.ItemInfoRepository;
import Services.Interfaces.ItemInfoServiceInterface;
import Models.ItemInfo;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Item info service.
 */
public class ItemInfoService implements ItemInfoServiceInterface {

    private static final ItemInfoService instance = new ItemInfoService();
    private ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();
    private ItemInfoFactory itemInfoFactory = ItemInfoFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    @Override
    public ItemInfo FindById(int id) throws ExceptionCustom {
        ItemInfo itemInfo = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    itemInfo = this.itemInfoRepository.FindById(id);
                    if (itemInfo == null)
                    {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                        throw exceptionErreurBD;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("ce code UPC est introuvable dans le catalogue");
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }else{
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return itemInfo;
    }

    @Override
    public List<ItemInfo> FindAll() throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connection == null)
        {
            try {
               itemInfo = this.itemInfoRepository.FindAll();
                if (itemInfo == null)
                {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                    throw exceptionErreurBD;
                }
            } catch (Exception e) {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                throw exceptionErreurBD;
            }
        }
        else
        {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return new ArrayList<>();
    }

    public List<ItemInfo> SortByName() throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connection == null)
        {
            try {
                itemInfo = this.itemInfoRepository.SortByName();
                if (itemInfo == null)
                {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                    throw exceptionErreurBD;
                }
            } catch (Exception e) {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                throw exceptionErreurBD;
            }
        }
        else
        {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return new ArrayList<>();
    }

    @Override
    public List<ItemInfo> FindByName(String name) throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (this.verificationService.verifier(name)) {
            if (connection == null) {
                try {
                    name = verificationService.normalisation(name);
                    itemInfo = this.itemInfoRepository.FindByName(name);
                    if (itemInfo == null)
                    {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                        throw exceptionErreurBD;
                    }
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("ce code UPC est introuvable dans le catalogue");
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }else{
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return itemInfo;
    }

    @Override
    public boolean Update(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItem,poids,volume);

        if (valide)
        {
            valide = this.verificationService.verifier(description,nom);
        }

        if (valide) {
            description = verificationService.normalisation(description);
            nom = verificationService.normalisation(nom);
            ItemInfo nouveauItemInfo = FindById(idItem);
            nouveauItemInfo.setDescription(description);
            nouveauItemInfo.setNom(nom);
            nouveauItemInfo.setPoids(poids);
            nouveauItemInfo.setVolume(volume);

            if (connection == null) {
                try {
                    this.itemInfoRepository.Update(nouveauItemInfo);
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }
        else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    @Override
    public boolean Create(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItem,poids,volume);
        if (valide)
        {
            valide = this.verificationService.verifier(description,nom);
        }

        if (valide) {
            if (connection == null) {
                try {
                    description = verificationService.normalisation(description);
                    nom = verificationService.normalisation(nom);
                    itemInfoRepository.Create(this.itemInfoFactory.Create(idItem, description, nom, poids, volume));
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }
        else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies ou code UPC invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    @Override
    public boolean Delete(int id) throws ExceptionCustom {
        boolean valide = this.verificationService.verifier(id);

        if(valide) {
            if (connection == null) {
                try {
                    this.itemInfoRepository.Delete(id);
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("ce code UPC est introuvable dans le catalogue");
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    public static ItemInfoService GetInstance()
    {
        return instance;
    }
}
