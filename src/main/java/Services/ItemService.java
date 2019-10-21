package Services;

import Factory.ItemFactory;
import Models.ConnectionBD;
import Repositories.ItemRepository;
import Services.Interfaces.ItemServiceInterface;
import Models.Item;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Item service.
 */
public class ItemService implements ItemServiceInterface {

    private static final ItemService instance = new ItemService();
    private ItemRepository itemRepository = ItemRepository.GetInstance();
    private ItemFactory itemFactory = ItemFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    @Override
    public Item FindById(int id) throws ExceptionCustom {
        Item item = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    item = this.itemRepository.FindById(id);
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }
        else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return item;
    }

    @Override
    public int FindAmountById(int id) throws ExceptionCustom {
        int count = 0;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    count = this.itemRepository.FindAmountById(id);
                } catch (Exception e) {
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

        return count;
    }

    @Override
    public List<Item> FindAll() throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (connection == null)
        {
            try {
                item = this.itemRepository.FindAll();
            } catch (Exception e) {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                throw exceptionErreurBD;
            }
        }
        else
        {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
            throw exceptionErreurBD;
        }

        return item;
    }

    @Override
    public List<Item> FindByName(String name) throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (this.verificationService.verifier(name)) {
            if (connection == null) {
                try {
                    item = this.itemRepository.FindByName(name);
                } catch (Exception e) {
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

        return item;
    }

    @Override
    public boolean Update(int idItem, int idItemInfo, int idContainer, String description,int quantite, int emplacement) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItem,idItemInfo,idContainer,quantite,emplacement);
        if (valide)
        {
            valide = this.verificationService.verifier(description);
        }

        if (valide) {
            Item nouveauItem = FindById(idItem);
            nouveauItem.setIdItemInfo(idItemInfo);
            nouveauItem.setIdContainer(idContainer);
            nouveauItem.setDescription(description);
            nouveauItem.setQuantite(quantite);
            nouveauItem.setEmplacement(emplacement);

            if (connection == null) {
                try {
                    this.itemRepository.Update(nouveauItem);
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
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

    @Override
    public boolean Create(int idItemInfo, int idContainer, String description,int quantite, int emplacement) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItemInfo,idContainer,quantite,emplacement);
        if (valide)
        {
            valide = this.verificationService.verifier(description);
        }

        if (valide) {
            if (connection == null) {
                try {
                    itemRepository.Create(this.itemFactory.Create(0, idItemInfo, idContainer, description,quantite,emplacement));
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
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

    @Override
    public boolean Delete(int id) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(id);

        if (valide) {
            if (connection == null) {
                try {
                    this.itemRepository.Delete(id);
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
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

    public static ItemService GetInstance()
    {
        return instance;
    }
}
