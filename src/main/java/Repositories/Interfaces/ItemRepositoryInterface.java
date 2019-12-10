package Repositories.Interfaces;

import Models.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface Item repository interface.
 */
public interface ItemRepositoryInterface {
    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     * @throws Exception the exception
     */
    Item FindById(int id) throws Exception;

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     * @throws Exception the exception
     */
    List<Item> FindByName(String name) throws Exception;

    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<Item> FindAll() throws Exception;

    /**
     * Sort by name list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<Item> SortByName() throws Exception;

    /**
     * Find amount by id int.
     *
     * @param id the id
     * @return the int
     * @throws Exception the exception
     */
    int FindAmountById(int id) throws Exception;

    /**
     * Update.
     *
     * @param itemToUpdate the item to update
     * @throws Exception the exception
     */
    void Update(Item itemToUpdate) throws Exception;

    /**
     * Delete.
     *
     * @param id       the id
     * @param quantite the quantite
     * @throws Exception the exception
     */
    void Delete(int id, int quantite) throws Exception;

    /**
     * Create.
     *
     * @param itemToAdd the item to add
     * @throws Exception the exception
     */
    void Create(Item itemToAdd) throws Exception;

    /**
     * Find similar item.
     *
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @return the item
     * @throws Exception the exception
     */
    Item findSimilar(int idItemInfo, String emplacement, String description) throws Exception;

    /**
     * Find similar item.
     *
     * @param idItemInfo  the id item info
     * @param description the description
     * @return the item
     * @throws SQLException the sql exception
     */
    Item findSimilar(int idItemInfo, String description) throws SQLException;
}
