package Factory;

import Models.Item;

/**
 * The type Item factory.
 */
public class ItemFactory {

    private static final ItemFactory instance = new ItemFactory();

    /**
     * Get instance item factory.
     *
     * @return the item factory
     */
    public static ItemFactory GetInstance() {
        return instance;
    }

    /**
     * Create item.
     *
     * @param idItem      the id item
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @param quantite    the quantite
     * @return the item
     */
    public Item Create(int idItem, int idItemInfo, String emplacement, String description, int quantite) {
        Item ret = new Item();

        ret.setIdItem(idItem);
        ret.setIdItemInfo(idItemInfo);
        ret.setEmplacement(emplacement);
        ret.setDescription(description);
        ret.setQuantite(quantite);

        return ret;
    }
}
