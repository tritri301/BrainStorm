package Models;

import java.sql.Date;

public class Commande {
    private int idCommande;
    private Date DateCommande;
    private Date DateLivraison;
    private int Etat;
    private Date DateLivraisonPrevu;
    private String nomPEnvoi;
    private String nomPRecu;

    public Date getDateLivraisonPrevu() {
        return DateLivraisonPrevu;
    }

    public void setDateLivraisonPrevu(Date dateLivraisonPrevu) {
        DateLivraisonPrevu = dateLivraisonPrevu;
    }

    public String getNomPEnvoi() {
        return nomPEnvoi;
    }

    public void setNomPEnvoi(String nomPEnvoi) {
        this.nomPEnvoi = nomPEnvoi;
    }

    public String getNomPRecu() {
        return nomPRecu;
    }

    public void setNomPRecu(String nomPRecu) {
        this.nomPRecu = nomPRecu;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateLivraison() {
        return DateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        DateLivraison = dateLivraison;
    }

    public Date getDateCommande() {
        return DateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        DateCommande = dateCommande;
    }
}
