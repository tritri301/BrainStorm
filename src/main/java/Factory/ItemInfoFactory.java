package Factory;

import Models.ItemInfo;

/**
 * The type Item info factory.
 */
public class ItemInfoFactory {
    private ItemInfo create(int idItem, String description, String nom, int poids, int volume) {
        ItemInfo ret= new ItemInfo();

        ret.setIdItemInfo(idItem);
        ret.setDescription(description);
        ret.setNom(nom);
        ret.setPoids(poids);
        ret.setVolume(volume);

        return ret;
    }
}