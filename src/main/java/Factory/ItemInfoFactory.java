package Factory;

import Models.ItemInfo;

/**
 * The type Item info factory.
 */
public class ItemInfoFactory {

    private static final ItemInfoFactory instance = new ItemInfoFactory();

    /**
     * Get instance item info factory.
     *
     * @return the item info factory
     */
    public static ItemInfoFactory GetInstance() {
        return instance;
    }

    /**
     * Create item info.
     *
     * @param idItem      the id item
     * @param description the description
     * @param nom         the nom
     * @param poids       the poids
     * @param volume      the volume
     * @return the item info
     */
    public ItemInfo Create(int idItem, String description, String nom, int poids, int volume) {
        ItemInfo ret = new ItemInfo();

        ret.setIdItemInfo(idItem);
        ret.setDescription(description);
        ret.setNom(nom);
        ret.setPoids(poids);
        ret.setVolume(volume);

        return ret;
    }
}