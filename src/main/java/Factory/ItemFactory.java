package Factory;

import Models.Item;

/**
 * The type Item factory.
 */
public class ItemFactory {

    private static final ItemFactory instance = new ItemFactory();

    public Item Create (int idItem, int idItemInfo, String emplacement, String description, int quantite) {
        Item ret = new Item();

        ret.setIdItem(idItem);
        ret.setIdItemInfo(idItemInfo);
        ret.setEmplacement(emplacement);
        ret.setDescription(description);
        ret.setQuantite(quantite);

        return ret;
    }
    public static ItemFactory GetInstance(){ return instance;}
}
