package Controllers.Interface;

import Models.ItemInfo;

import java.util.List;

/**
 * The interface Item info controller interface.
 */
public interface ItemInfoControllerInterface {

    /**
     * Find by id item info.
     *
     * @param id the id
     * @return the item info
     */
    ItemInfo FindById(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ItemInfo> FindAll();

    /**
     * Sort by name list.
     *
     * @return the list
     */
    List<ItemInfo> SortByName();

    /**
     * Find by name item info.
     *
     * @param name the name
     * @return the item info
     */
    List<ItemInfo> FindByName(String name);

    /**
     * Update item info.
     *
     * @param idItem      the id item
     * @param description the description
     * @param nom         the nom
     * @param poids       the poids
     * @param volume      the volume
     * @return the item info
     */
    boolean Update(int idItem, String description, String nom, int poids, int volume);

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
    boolean Create(int idItem, String description, String nom, int poids, int volume);

    /**
     * Delete item info.
     *
     * @param id the id
     * @return the item info
     */
    boolean Delete(int id);
}
