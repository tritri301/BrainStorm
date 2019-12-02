package Factory;

import Models.Commande;

import java.sql.Date;

public class CommandeFactory {
    private static final CommandeFactory instance = new CommandeFactory();

    public Commande Create(int idCommande, Date dateCommande, Date dateLivraison, int etat,Date dateLivraisonPrevu,String nomPEnvoi,String nomPRecu) {
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
    public static CommandeFactory GetInstance(){return instance;}
}
