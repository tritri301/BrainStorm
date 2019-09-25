package Services.Interfaces;

import Models.ItemInfo;

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

    /**
     * Find by name item info.
     *
     * @param name the name
     * @return the item info
     */
    public ItemInfo FindByName(String name);

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
