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
    public ItemInfo Update(int id);

    /**
     * Create item info.
     *
     * @return the item info
     */
    public ItemInfo Create();

    /**
     * Delete item info.
     *
     * @param id the id
     * @return the item info
     */
    public ItemInfo Delete(int id);
}
