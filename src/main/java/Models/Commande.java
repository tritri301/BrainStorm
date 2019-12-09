package Models;

import java.sql.Date;

/**
 * The type Commande.
 */
public class Commande {
    private int idCommande;
    private Date dateCommande;
    private Date dateLivraison;
    private int etat;
    private Date dateLivraisonPrevu;
    private String nomPEnvoi;
    private String nomPRecu;

    /**
     * Gets date livraison prevu.
     *
     * @return the date livraison prevu
     */
    public Date getDateLivraisonPrevu() {
        return dateLivraisonPrevu;
    }

    /**
     * Sets date livraison prevu.
     *
     * @param dateLivraisonPrevu the date livraison prevu
     */
    public void setDateLivraisonPrevu(Date dateLivraisonPrevu) {
        this.dateLivraisonPrevu = dateLivraisonPrevu;
    }

    /**
     * Gets nom p envoi.
     *
     * @return the nom p envoi
     */
    public String getNomPEnvoi() {
        return nomPEnvoi;
    }

    /**
     * Sets nom p envoi.
     *
     * @param nomPEnvoi the nom p envoi
     */
    public void setNomPEnvoi(String nomPEnvoi) {
        this.nomPEnvoi = nomPEnvoi;
    }

    /**
     * Gets nom p recu.
     *
     * @return the nom p recu
     */
    public String getNomPRecu() {
        return nomPRecu;
    }

    /**
     * Sets nom p recu.
     *
     * @param nomPRecu the nom p recu
     */
    public void setNomPRecu(String nomPRecu) {
        this.nomPRecu = nomPRecu;
    }

    /**
     * Gets id commande.
     *
     * @return the id commande
     */
    public int getIdCommande() {
        return idCommande;
    }

    /**
     * Sets id commande.
     *
     * @param idCommande the id commande
     */
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    /**
     * Gets etat.
     *
     * @return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * Sets etat.
     *
     * @param etat the etat
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     * Gets date livraison.
     *
     * @return the date livraison
     */
    public Date getDateLivraison() {
        return dateLivraison;
    }

    /**
     * Sets date livraison.
     *
     * @param dateLivraison the date livraison
     */
    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    /**
     * Gets date commande.
     *
     * @return the date commande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Sets date commande.
     *
     * @param dateCommande the date commande
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
}
