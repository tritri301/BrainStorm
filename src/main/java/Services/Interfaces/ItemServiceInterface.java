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

    public Item[] FindAll();

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
     * @return the item
     */
    public boolean Update(int idItem, int idItemInfo, int idContainer, String description);

    /**
     * Create item.
     *
     * @return the item
     */
    public boolean Create(int idItem, int idItemInfo, int idContainer, String description);

    /**
     * Delete item.
     *
     * @param id the id
     * @return the item
     */
    public boolean Delete(int id);
}
