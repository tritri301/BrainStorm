package Services;

import Factory.ItemCommandeFactory;
import Factory.ItemFactory;
import Models.ConnectionBD;
import Models.ItemCommande;
import Repositories.Interfaces.ItemCommandeRepositoryInterface;
import Repositories.ItemCommandeRepository;
import Services.Interfaces.ItemCommandeServiceInterface;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

public class ItemCommandeService implements ItemCommandeServiceInterface {

    private static final ItemCommandeService instance = new ItemCommandeService();

    private ItemCommandeFactory itemCommandeFactory = ItemCommandeFactory.GetInstance();
    private ItemCommandeRepository itemCommandeRepository = ItemCommandeRepository.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private VerificationService verificationService = VerificationService.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();


    public static ItemCommandeService GetInstance()
    {
        return instance;
    }

    @Override
    public ItemCommande FindById(int id) throws Exception {

        ItemCommande itemCommande = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    itemCommande = this.itemCommandeRepository.FindById(id);
                } catch (Exception e) {
                    throw new ExceptionCustom("l'objet que vous recherché est introuvable");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return itemCommande;
    }

    @Override
    public List<ItemCommande> FindByIdCommande(int idCommande) throws Exception {
        List<ItemCommande> itemCommande = new ArrayList<ItemCommande>();
        if (connection == null) {
            try {
                itemCommande = this.itemCommandeRepository.FindByIdCommande(idCommande);
                if (itemCommande == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return itemCommande;
    }

    @Override
    public List<ItemCommande> FindAll() throws Exception {
        List<ItemCommande> itemCommande = new ArrayList<ItemCommande>();
        if (connection == null) {
            try {
                itemCommande = this.itemCommandeRepository.FindAll();
                if (itemCommande == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return itemCommande;
    }

    @Override
    public boolean Update(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite) throws Exception {
        return true;
    }

    @Override
    public boolean Create(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite) throws Exception {
        boolean valide = false;
        if (quantite > 0) {
            if (verificationService.itemInfoExist(idItemInfo)) {
                    if (verificationService.verifierDescription(description)) {
                        if (connection == null) {
                            try {
                                itemCommandeRepository.Create(itemCommandeFactory.Create(idItemCommande, idCommande, idItemInfo,description,quantite));
                                valide = true;
                            } catch (Exception e) {
                                throw new ExceptionCustom("Erreur de bd : " + e.toString());
                            }

                        } else {
                            throw new ExceptionCustom("Erreur de connection a la base de données");
                        }
                    }
                    else {
                        throw new ExceptionCustom("la description na pas le bon format");
                    }
            }
            else {
                throw new ExceptionCustom("le code upc est invalide");
            }
        }
        else {
            throw new ExceptionCustom("la quantité est invalide");
        }
        return valide;
    }
}
