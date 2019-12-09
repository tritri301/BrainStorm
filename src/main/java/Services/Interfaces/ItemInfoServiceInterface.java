package Services.Interfaces;

import Exception.ExceptionCustom;
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
     * @throws ExceptionCustom the exception custom
     */
    ItemInfo FindById(int id) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
    List<ItemInfo> FindAll() throws ExceptionCustom;

    /**
     * Find by name item info.
     *
     * @param name the name
     * @return the item info
     * @throws ExceptionCustom the exception custom
     */
    List<ItemInfo> SortByName() throws ExceptionCustom;

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
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
     * @throws ExceptionCustom the exception custom
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
     * @throws ExceptionCustom the exception custom
     */
    boolean Create(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom;

    /**
     * Delete item info.
     *
     * @param id the id
     * @return the item info
     * @throws ExceptionCustom the exception custom
     */
    boolean Delete(int id) throws ExceptionCustom;
}
