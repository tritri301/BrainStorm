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
                } catch (Exception e) {
                    e.printStackTrace();
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
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
    public List<ItemInfo> FindAll() {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connection == null)
        {
            try {
               // itemInfo = this.itemInfoRepository.FindAll();
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
    public List<ItemInfo> FindByName(String name) {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (this.verificationService.verifier(name)) {
            if (connection == null) {
                try {
                    itemInfo = this.itemInfoRepository.FindByName(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }else{
            //donnée entré non valide
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
    public boolean Create(int idItem, String description, String nom, int poids, int volume) {

        boolean valide = this.verificationService.verifier(idItem,poids,volume);
        if (valide)
        {
            valide = this.verificationService.verifier(description,nom);
        }

        if (valide) {
            if (connection == null) {
                try {
                    itemInfoRepository.Create(this.itemInfoFactory.Create(idItem, description, nom, poids, volume));
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

        if(valide) {
            if (connection == null) {
                try {
                    this.itemInfoRepository.Delete(id);
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

    public static ItemInfoService GetInstance()
    {
        return instance;
    }
}
