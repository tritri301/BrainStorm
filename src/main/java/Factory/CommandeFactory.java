package Factory;

import Models.Commande;

import java.sql.Date;

/**
 * The type Commande factory.
 */
public class CommandeFactory {
    private static final CommandeFactory instance = new CommandeFactory();

    /**
     * Get instance commande factory.
     *
     * @return the commande factory
     */
    public static CommandeFactory GetInstance() {
        return instance;
    }

    /**
     * Create commande.
     *
     * @param idCommande         the id commande
     * @param dateCommande       the date commande
     * @param dateLivraison      the date livraison
     * @param etat               the etat
     * @param dateLivraisonPrevu the date livraison prevu
     * @param nomPEnvoi          the nom p envoi
     * @param nomPRecu           the nom p recu
     * @return the commande
     */
    public Commande Create(int idCommande, Date dateCommande, Date dateLivraison, int etat, Date dateLivraisonPrevu, String nomPEnvoi, String nomPRecu) {
        Commande ret = new Commande();

        ret.setIdCommande(idCommande);
        ret.setDateCommande(dateCommande);
        ret.setDateLivraison(dateLivraison);
        ret.setEtat(etat);
        ret.setDateLivraisonPrevu(dateLivraisonPrevu);
        ret.setNomPEnvoi(nomPEnvoi);
        ret.setNomPRecu(nomPRecu);

        return ret;
    }
}
