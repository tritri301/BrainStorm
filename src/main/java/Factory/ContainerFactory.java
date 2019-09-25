package Factory;

public class ContainerFactory {

    int idItem;
    int idItemInfo;
    int idContainer;
    String description;

    public ContainerFactory(int idItem, int idItemInfo, int idContainer, String description) {
        this.idItem = idItem;
        this.idItemInfo = idItemInfo;
        this.idContainer = idContainer;
        this.description = description;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setIdItemInfo(int idItemInfo) {
        this.idItemInfo = idItemInfo;
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

    public int getIdItemInfo() {
        return idItemInfo;
    }

    public int getIdContainer() {
        return idContainer;
    }

    public String getDescription() {
        return description;
    }
}
