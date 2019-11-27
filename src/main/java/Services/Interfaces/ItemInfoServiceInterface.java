package Services.Interfaces;

import Models.ItemInfo;
import Exception.*;
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
    ItemInfo FindById(int id) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ItemInfo> FindAll() throws ExceptionCustom;

    /**
     * Find by name item info.
     *
     * @param name the name
     * @return the item info
     */

    List<ItemInfo> SortByName() throws ExceptionCustom;

    List<ItemInfo> FindByName(String name) throws ExceptionCustom;

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
    boolean Update(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom;

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
    boolean Create(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom;

    /**
     * Delete item info.
     *
     * @param id the id
     * @return the item info
     */
    boolean Delete(int id) throws ExceptionCustom;
}
