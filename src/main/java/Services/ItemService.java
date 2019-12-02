package Services;

import Factory.ItemFactory;
import Models.ConnectionBD;
import Repositories.ItemRepository;
import Services.Interfaces.ItemServiceInterface;
import Models.Item;
import Exception.*;

import java.util.ArrayList;
import java.util.List;
//
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
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("l'objet que vous recherché est introuvable");
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
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
                    if (count == 0) {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                        throw exceptionErreurBD;
                    }
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("l'objet que vous recherché est introuvable par quantite");
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }
//yolo
        return count;
    }

    @Override
    public List<Item> FindAll() throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (connection == null) {
            try {
                item = this.itemRepository.FindAll();
                if (item == null) {
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

        return item;
    }

    @Override
    public List<Item> SortByName() throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (connection == null) {
            try {
                item = this.itemRepository.SortByName();
                if (item == null) {
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
                    if (item == null) {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                        throw exceptionErreurBD;
                    }
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("l'objet que vous recherché est introuvable");
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return item;
    }

    @Override
    public boolean Update(int idItem, int idItemInfo, String emplacement, String description, int quantite) throws ExceptionCustom {
        boolean valide = false;

        if (this.verificationService.verifier(quantite)) {
            if (verificationService.itemInfoExist(idItemInfo)) {
                if (verificationService.emplacementExist(emplacement)) {
                    if (verificationService.verifierDescription(description)) {

                        emplacement = verificationService.normalisation(emplacement);
                        //TODO verifiermieux apres =, et tout enlever sauf , t =
                        Item nouveauItem = FindById(idItem);
                        nouveauItem.setIdItemInfo(idItemInfo);
                        nouveauItem.setEmplacement(emplacement);
                        nouveauItem.setDescription(description);
                        nouveauItem.setQuantite(quantite);

                        if (connection == null) {
                            try {
                                this.itemRepository.Update(nouveauItem);
                                valide = true;
                            } catch (Exception e) {
                                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                                throw exceptionErreurBD;
                            }
                        } else {
                            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                            throw exceptionErreurBD;
                        }
                    }
                    else {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("la description na pas le bon format");
                        throw exceptionErreurBD;
                    }
                }
                else {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("l'emplacement est invalide");
                    throw exceptionErreurBD;
                }
            }
            else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("le code upc est invalide");
                throw exceptionErreurBD;
            }
        }
        else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("la quantité est invalide");
            throw exceptionErreurBD;
        }
        return valide;
    }

    @Override
    public boolean Create(int idItemInfo, String emplacement, String description,int quantite) throws ExceptionCustom {

        boolean valide = false;

        if (this.verificationService.verifier(quantite)) {
            if (verificationService.itemInfoExist(idItemInfo)) {
                if (verificationService.emplacementExist(emplacement)) {
                    if (verificationService.verifierDescription(description)) {
                        emplacement = verificationService.normalisation(emplacement);
                        //TODO verifiermieux apres =, et tout enlever sauf , t =
                        if (connection == null) {
                            try {

                                Item item = null;
                                item = this.trouverSimilaire(idItemInfo, emplacement, description);

                                if(item != null)
                                {
                                    quantite = quantite + item.getQuantite();
                                    this.Update(item.getIdItem(),idItemInfo,emplacement,description,quantite);
                                }
                                else
                                {
                                    itemRepository.Create(this.itemFactory.Create(0, idItemInfo, emplacement, description, quantite));
                                }
                                valide = true;
                            } catch (Exception e) {
                                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                                throw exceptionErreurBD;
                            }

                        } else {
                            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                            throw exceptionErreurBD;
                        }
                    }
                    else {
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("la description na pas le bon format");
                        throw exceptionErreurBD;
                    }
                }
                else {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("l'emplacement est invalide");
                    throw exceptionErreurBD;
                }
            }
            else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("le code upc est invalide");
                throw exceptionErreurBD;
            }
        }
        else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("la quantité est invalide");
            throw exceptionErreurBD;
        }
        return valide;
    }

    @Override
    public boolean Delete(int id, int quantite) throws ExceptionCustom {
        boolean valide = true;
        boolean valideId = this.verificationService.verifier(id);
        boolean valideQt = this.verificationService.verifier(quantite);
        if(valideQt) {
            if (valideId) {
                if (connection == null) {
                    try {
                        //verifier Quantite
                            this.itemRepository.Delete(id, quantite);
                    }catch(ExceptionCustom e) {
                        throw e;
                    } catch (Exception e) {
                        valide = false;
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("l'objet que vous recherché est introuvable");
                        throw exceptionErreurBD;
                    }
                } else {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
                throw exceptionErreurBD;
            }
        } else {
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }
        return valide;
    }
    public boolean MoveItem(int id,int quantite,String emplacementNouveau) throws ExceptionCustom
    {
        boolean valide = true;

        if (verificationService.itemExist(id))
        {
            if (verificationService.verifier(quantite))
            {
                if (verificationService.verifierQuantiteRestante(id,quantite))
                {
                    if (verificationService.emplacementExist(emplacementNouveau))
                    {
                        Item item = FindById(id);
                        Update(id,item.getIdItemInfo(),item.getEmplacement(),item.getDescription(),item.getQuantite() - quantite);
                        Delete(id,0);
                        Create(item.getIdItemInfo(),emplacementNouveau,item.getDescription(),quantite);
                    }
                    else
                    {
                        valide = false;
                        ExceptionCustom exceptionErreurBD = new ExceptionCustom("le nouvelle emplacement n'est pas valide");
                        throw exceptionErreurBD;
                    }
                }
                else
                {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("vous déplacer plus d'object que la quantité en stock");
                    throw exceptionErreurBD;
                }
            }
            else
            {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("format de Quantite invalide");
                throw exceptionErreurBD;
            }
        }
        else
        {
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun object avec id : " + id);
            throw exceptionErreurBD;
        }


        return valide;
    }

    @Override
    public boolean ModifyItem(int id, String description) throws ExceptionCustom {
        boolean valide = true;

        if (verificationService.itemExist(id))
        {
            if (verificationService.verifierDescription(description))
            {
                Item item = FindById(id);
                Update(id,item.getIdItemInfo(),item.getEmplacement(),description,item.getQuantite());
            }
            else
            {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("la description ne possede pas de bon format");
                throw exceptionErreurBD;
            }

        }else
        {
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun object avec id : " + id);
            throw exceptionErreurBD;
        }

        return valide;





    }

    @Override
    public Item trouverSimilaire(int idItemInfo, String emplacement, String description) {
        Item item = null;
        try {
            item = itemRepository.findSimilar(idItemInfo,emplacement,description);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public Item trouverSimilaire(int idItemInfo, String description) {

            Item item = null;
            try {
                item = itemRepository.findSimilar(idItemInfo,description);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return item;
    }

    public static ItemService GetInstance()
    {
        return instance;
    }
}
