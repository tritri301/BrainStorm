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
                                itemRepository.Create(this.itemFactory.Create(0, idItemInfo, emplacement, description, quantite));
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
    public boolean Delete(int id) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(id);

        if (valide) {
            if (connection == null) {
                try {
                    this.itemRepository.Delete(id);
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
        }else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }
    public boolean MoveItem(int id,int quantite,String emplacementNouveau) throws ExceptionCustom
    {
        boolean valide = true;


        // Logique pour déplacement Simon
        /*
         ItemController itemController = ItemController.GetInstance();
            Item item = itemController.FindById(id);


            if (item.getQuantite() == 1) {
                //update emplacement
                itemController.Update(id,item.getIdItemInfo(),emplacementNouveau,item.getDescription(),item.getQuantite());
            } else {
                itemController.Update(id,item.getIdItemInfo(),emplacementNouveau,item.getDescription(),quantite);
                itemController.Update(id,item.getIdItemInfo(),item.getEmplacement(),item.getDescription(),item.getQuantite() - quantite);
               // ajouter avec le nouvel emplacement avec la quantite voulu
               // update de l 'ancien diminuer quantite'
      }

         */
        return valide;
    }

    public boolean ModifyItem(int id,String description) throws ExceptionCustom
    {
        boolean valide = true;

        //Logique pour service Simon
        /*
        ItemController itemController = ItemController.GetInstance();
        Item item = itemController.FindById(id);

        itemController.Update(id,item.getIdItemInfo(),item.getEmplacement(),description,item.getQuantite();

         */

        return valide;
    }
    public static ItemService GetInstance()
    {
        return instance;
    }
}
