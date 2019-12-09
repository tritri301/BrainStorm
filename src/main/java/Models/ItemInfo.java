package Models;

/**
 * The type Item info.
 */
public class ItemInfo
{
    private int idItemInfo;
    private String description;
    private String nom;
    private int poids;
    private int volume;

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
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets poids.
     *
     * @return the poids
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Sets poids.
     *
     * @param poids the poids
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
