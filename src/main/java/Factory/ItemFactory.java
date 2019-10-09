package Factory;

import Models.Item;

/**
 * The type Item factory.
 */
public class ItemFactory {

    private static final ItemFactory instance = new ItemFactory();

    public Item Create (int idItemInfo, int idContainer, String description) {
        Item ret = new Item();

        ret.setIdItemInfo(idItemInfo);
        ret.setIdContainer(idContainer);
        ret.setDescription(description);

        return ret;
    }
    public static ItemFactory GetInstance(){ return instance;}
}
