package Factory;

import Models.Item;

public class ItemFactory {
    private Item create (int idItem, int idItemInfo, int idContainer, String description) {
        Item ret = new Item();

        ret.setIdItem(idItem);
        ret.setIdItemInfo(idItemInfo);
        ret.setIdContainer(idContainer);
        ret.setDescription(description);

        return ret;
    }
}
