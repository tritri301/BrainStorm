package Factory;

import Models.Item;

/**
 * The type Item factory.
 */
public class ItemFactory {

    private static final ItemFactory instance = new ItemFactory();

    public Item Create (int idItem, int idItemInfo, int idContainer, String description) {
        Item ret = new Item();

        ret.setIdItem(idItem);
        ret.setIdItemInfo(idItemInfo);
        ret.setIdContainer(idContainer);
        ret.setDescription(description);

        return ret;
    }
    public static ItemFactory GetInstance(){ return instance;}
}
