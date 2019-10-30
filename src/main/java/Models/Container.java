package Models;

/**
 * The type Container.
 */
public class Container
{
    private String Emplacement;
    private int volume;
    private int volumeMax;
    private int poids;
    private int poidsMax;
    private String emplacementParent;

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

    public String getEmplacementParent() {
        return emplacementParent;
    }

    public void setEmplacementParent(String emplacementParent) {
        this.emplacementParent = emplacementParent;
    }
}
