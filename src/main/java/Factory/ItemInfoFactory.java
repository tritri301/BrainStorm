package Factory;

public class ItemInfoFactory {

    int idItem;
    String description;
    String nom;
    int Poids;
    int volume;

    public ItemInfoFactory(int idItem, String description, String nom, int poids, int volume) {
        this.idItem = idItem;
        this.description = description;
        this.nom = nom;
        Poids = poids;
        this.volume = volume;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoids(int poids) {
        Poids = poids;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getIdItem() {
        return idItem;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public int getPoids() {
        return Poids;
    }

    public int getVolume() {
        return volume;
    }
}

