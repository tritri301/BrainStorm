package Services.Interfaces;

import Models.Item;

/**
 * The interface Item service interface.
 */
public interface ItemServiceInterface {
    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    public Item FindById(int id);

    /**
     * Find by name item.
     *
     * @param name the name
     * @return the item
     */
    public Item FindByName(String name);

    /**
     * Update item.
     *
     * @param id the id
     * @return the item
     */
    public Item Update(int id);

    /**
     * Create item.
     *
     * @return the item
     */
    public Item Create();

    /**
     * Delete item.
     *
     * @param id the id
     * @return the item
     */
    public Item Delete(int id);
}
