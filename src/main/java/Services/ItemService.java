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
                    if (e.toString().equals("java.sql.SQLException: Illegal operation on empty result set."))
                    {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun résultats");
                        throw exceptionErreurBD;
                    }
                    else
                    {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd :t " + e.toString());
                        throw exceptionErreurBD;
                    }
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
                    if (count == 0)
                    {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                        throw exceptionErreurBD;
                    }
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
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
                if (item == null)
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
                    name = verificationService.normalisation(name);
                    item = this.itemRepository.FindByName(name);
                    if (item == null)
                    {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                        throw exceptionErreurBD;
                    }
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
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
    public boolean Update(int idItem, int idItemInfo, String emplacement, String description,int quantite) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItem,idItemInfo,quantite);

        if (valide) {

            description = verificationService.normalisation(description);
            emplacement = verificationService.normalisation(emplacement);

            Item nouveauItem = FindById(idItem);
            nouveauItem.setIdItemInfo(idItemInfo);
            nouveauItem.setEmplacement(emplacement);
            nouveauItem.setDescription(description);
            nouveauItem.setQuantite(quantite);

            if (connection == null) {
                try {
                    this.itemRepository.Update(nouveauItem);
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
        }else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    @Override
    public boolean Create(int idItemInfo, String emplacement, String description,int quantite) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItemInfo,quantite);

        if (valide) {

            emplacement = verificationService.normalisation(emplacement);
            description = verificationService.normalisation(description);

            if (connection == null) {
                try {
                    itemRepository.Create(this.itemFactory.Create(0, idItemInfo, emplacement, description,quantite));
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("Erreur de bd :" + e.toString());
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        }else{
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
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
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd :" + e.toString());
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
