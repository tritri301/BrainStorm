package Models;

public class Container
{
    private int idContainer;
    private int quantite;
    private int position;
    private int volume;
    private int poidsMax;
    private int idContainerParent;

    public int getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
