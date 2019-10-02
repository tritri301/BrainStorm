package Services.Interfaces;

import Models.Item;

import java.util.List;

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
    Item FindById(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Item> FindAll();

    /**
     * Find by name item.
     *
     * @param name the name
     * @return the item
     */
    List<Item> FindByName(String name);

    /**
     * Update item.
     *
     * @param idItem      the id item
     * @param idItemInfo  the id item info
     * @param idContainer the id container
     * @param description the description
     * @return the item
     */
    boolean Update(int idItem, int idItemInfo, int idContainer, String description);

    /**
     * Create item.
     *
     * @param idItem      the id item
     * @param idItemInfo  the id item info
     * @param idContainer the id container
     * @param description the description
     * @return the item
     */
    boolean Create(int idItem, int idItemInfo, int idContainer, String description);

    /**
     * Delete item.
     *
     * @param id the id
     * @return the item
     */
    boolean Delete(int id);
}
