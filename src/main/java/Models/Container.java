package Models;

/**
 * The type Container.
 */
public class Container
{
    private String emplacement;
    private int volume;
    private int volumeMax;
    private int poids;
    private int poidsMax;
    private String emplacementParent;

    /**
     * Gets emplacement.
     *
     * @return the emplacement
     */
    public String getEmplacement() {
        return emplacement;
    }

    /**
     * Sets emplacement.
     *
     * @param emplacement the emplacement
     */
    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
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
     * Gets volume max.
     *
     * @return the volume max
     */
    public int getVolumeMax() {
        return volumeMax;
    }

    /**
     * Sets volume max.
     *
     * @param volumeMax the volume max
     */
    public void setVolumeMax(int volumeMax) {
        this.volumeMax = volumeMax;
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
     * Gets emplacement parent.
     *
     * @return the emplacement parent
     */
    public String getEmplacementParent() {
        return emplacementParent;
    }

    /**
     * Sets emplacement parent.
     *
     * @param emplacementParent the emplacement parent
     */
    public void setEmplacementParent(String emplacementParent) {
        this.emplacementParent = emplacementParent;
    }
}
