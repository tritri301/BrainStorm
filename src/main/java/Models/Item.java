package Models;

/**
 * The type Item.
 */
public class Item
{
    private int idItem;
    private int idItemInfo;
    private String emplacement;
    private int quantite;
    private String description;

    /**
     * Gets id item.
     *
     * @return the id item
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * Sets id item.
     *
     * @param idItem the id item
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
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
     * Gets id container.
     *
     * @return the id container
     */
    public String getEmplacement() {
        return emplacement;
    }

    /**
     * Sets id container.
     *
     */
    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
