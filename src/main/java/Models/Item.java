package Models;

/**
 * The type Item.
 */
public class Item
{
    private int idItem;
    private int idItemInfo;
    private int idContainer;
    private int emplacement;
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
    public int getIdContainer() {
        return idContainer;
    }

    /**
     * Sets id container.
     *
     * @param idContainer the id container
     */
    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public int getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(int emplacement) {
        this.emplacement = emplacement;
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
