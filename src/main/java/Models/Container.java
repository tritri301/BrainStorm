package Models;

/**
 * The type Container.
 */
public class Container
{
    private int idContainer;
    private String Emplacement;
    private int volume;
    private int volumeMax;
    private int poids;
    private int poidsMax;
    private int idContainerParent;

    public int getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public String getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(String emplacement) {
        Emplacement = emplacement;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(int poidsMax) {
        this.poidsMax = poidsMax;
    }

    public int getIdContainerParent() {
        return idContainerParent;
    }

    public void setIdContainerParent(int idContainerParent) {
        this.idContainerParent = idContainerParent;
    }
}
