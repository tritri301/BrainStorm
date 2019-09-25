package Models;

public class ItemInfo
{
    private int idItemInfo;
    private String description;
    private String nom;
    private int poids;
    private int Volume;

    public int getIdItemInfo() {
        return idItemInfo;
    }

    public void setIdItemInfo(int idItemInfo) {
        this.idItemInfo = idItemInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int volume) {
        Volume = volume;
    }
}
