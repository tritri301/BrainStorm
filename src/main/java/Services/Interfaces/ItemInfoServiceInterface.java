package Services.Interfaces;

import Models.ItemInfo;

import java.util.List;

/**
 * The interface Item info service interface.
 */
public interface ItemInfoServiceInterface {
    /**
     * Find by id item info.
     *
     * @param id the id
     * @return the item info
     */
    public ItemInfo FindById(int id);
    public List<ItemInfo> FindAll();

    /**
     * Find by name item info.
     *
     * @param name the name
     * @return the item info
     */
    public List<ItemInfo> FindByName(String name);

    /**
     * Update item info.
     *
     * @param id the id
     * @return the item info
     */
    public boolean Update(int idItem, String description, String nom, int poids, int volume);

    /**
     * Create item info.
     *
     * @return the item info
     */
    public boolean Create(int idItem, String description, String nom, int poids, int volume);

    /**
     * Delete item info.
     *
     * @param id the id
     * @return the item info
     */
    public boolean Delete(int id);
}
