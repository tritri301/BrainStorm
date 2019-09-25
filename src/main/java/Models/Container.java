package Models;

/**
 * The type Container.
 */
public class Container
{
    private int idContainer;
    private int quantite;
    private int position;
    private int volume;
    private int poidsMax;
    private int idContainerParent;

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

    /**
     * Gets position.
     *
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(int position) {
        this.position = position;
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

    /**
     * Gets poids max.
     *
     * @return the poids max
     */
    public int getPoidsMax() {
        return poidsMax;
    }

    /**
     * Sets poids max.
     *
     * @param poidsMax the poids max
     */
    public void setPoidsMax(int poidsMax) {
        this.poidsMax = poidsMax;
    }

    /**
     * Gets id container parent.
     *
     * @return the id container parent
     */
    public int getIdContainerParent() {
        return idContainerParent;
    }

    /**
     * Sets id container parent.
     *
     * @param idContainerParent the id container parent
     */
    public void setIdContainerParent(int idContainerParent) {
        this.idContainerParent = idContainerParent;
    }
}
