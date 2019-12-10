package Models;

/**
 * The type Item commande.
 */
public class ItemCommande {
    private int idItemCommande;
    private int idCommande;
    private int idItemInfo;
    private String description;
    private int quantite;

    /**
     * Gets id item commande.
     *
     * @return the id item commande
     */
    public int getIdItemCommande() {
        return idItemCommande;
    }

    /**
     * Sets id item commande.
     *
     * @param idItemCommande the id item commande
     */
    public void setIdItemCommande(int idItemCommande) {
        this.idItemCommande = idItemCommande;
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
     * Gets id item info.
     *
     * @return the id item info
     */
    public int getIdItemInfo() {
        return idItemInfo;
    }

    /**
     * Sets id item info.
     *
     * @param idItemInfo the id item info
     */
    public void setIdItemInfo(int idItemInfo) {
        this.idItemInfo = idItemInfo;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets quantite.
     *
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Sets quantite.
     *
     * @param quantite the quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
