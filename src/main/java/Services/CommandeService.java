package Services;

import Exception.ExceptionCustom;
import Factory.CommandeFactory;
import Factory.ItemFactory;
import Models.Commande;
import Models.ConnectionBD;
import Models.Item;
import Repositories.CommandeRepository;
import Repositories.ItemRepository;
import Services.Interfaces.CommandeServiceInterface;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Commande service.
 */
public class CommandeService implements CommandeServiceInterface {

    private static final CommandeService instance = new CommandeService();
    private CommandeRepository commandeRepository = CommandeRepository.GetInstance();
    private CommandeFactory commandeFactory = CommandeFactory.GetInstance();
    private ItemService itemService = ItemService.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();
    private ItemRepository itemRepository = ItemRepository.GetInstance();
    private ItemFactory itemFactory = ItemFactory.GetInstance();

    /**
     * Get instance commande service.
     *
     * @return the commande service
     */
    public static CommandeService GetInstance() {
        return instance;
    }

    @Override
    public Commande FindById(int id) throws Exception {

        Commande commande = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    commande = this.commandeRepository.FindById(id);
                } catch (Exception e) {
                    throw new ExceptionCustom("l'objet que vous recherché est introuvable");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return commande;
    }

    @Override
    public Commande FindByIdItem(int id) throws Exception {
        Commande commande = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    commande = this.commandeRepository.FindByIdItem(id);
                } catch (Exception e) {
                    throw new ExceptionCustom("l'objet que vous recherché est introuvable");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return commande;
    }

    @Override
    public List<Commande> FindAll() throws Exception {
        List<Commande> commande = new ArrayList<Commande>();
        if (connection == null) {
            try {
                commande = this.commandeRepository.FindAll();
                if (commande == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return commande;
    }

    @Override
    public boolean Update(int idCommande, int etat, String nomPRecu) throws Exception {
        boolean valide = false;

        Date dateLivraison = new Date(System.currentTimeMillis());
        Commande commande = FindById(idCommande);
        commande.setDateLivraison(dateLivraison);
        commande.setEtat(etat);
        commande.setNomPRecu(nomPRecu);

        if (connection == null) {
            try {
                this.commandeRepository.Update(commande);
                valide = true;
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return valide;
    }

    @Override
    public int Create(String nomPEnvoi) throws Exception {
        boolean valide = false;
        int id;

        if (connection == null) {
            try {
                Item item = null;
                Date dateCommande = new Date(System.currentTimeMillis());
                java.sql.Date dateLivraisonPrevu = new java.sql.Date(dateCommande.getTime() + (14 * (24 * 60 * 60 * 1000)));
                id = commandeRepository.Create(commandeFactory.Create(0, dateCommande, null, 0, dateLivraisonPrevu, nomPEnvoi, null));
                valide = true;
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return id;
    }
}