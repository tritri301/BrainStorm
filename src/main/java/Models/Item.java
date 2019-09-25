package Models;

public class Item
{
    private int idItem;
    private int idItemInfo;
    private int idContainer;
    private String description;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdItemInfo() {
        return idItemInfo;
    }

    public void setIdItemInfo(int idItemInfo) {
        this.idItemInfo = idItemInfo;
    }

    public int getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
