package Factory;

public class ItemFactory {
    int idItem;
    int idIteminfo;
    int idContainer;
    String description;

    public ItemFactory(int idItem, int idIteminfo, int idContainer, String description) {
        this.idItem = idItem;
        this.idIteminfo = idIteminfo;
        this.idContainer = idContainer;
        this.description = description;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setIdIteminfo(int idIteminfo) {
        this.idIteminfo = idIteminfo;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdItem() {
        return idItem;
    }

    public int getIdIteminfo() {
        return idIteminfo;
    }

    public int getIdContainer() {
        return idContainer;
    }

    public String getDescription() {
        return description;
    }
}
