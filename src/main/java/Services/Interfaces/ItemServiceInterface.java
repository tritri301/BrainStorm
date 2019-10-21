package Services.Interfaces;

import Models.Item;
import Exception.*;
import java.util.List;
import Exception.*;

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
    Item FindById(int id) throws ExceptionCustom;

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    int FindAmountById(int id) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Item> FindAll() throws ExceptionCustom;

    /**
     * Find by name item.
     *
     * @param name the name
     * @return the item
     */
    List<Item> FindByName(String name) throws ExceptionCustom;

    /**
     * Update item.
     *
     * @param idItem      the id item
     * @param idItemInfo  the id item info
     * @param idContainer the id container
     * @param description the description
     * @return the item
     */
    boolean Update(int idItem, int idItemInfo, int idContainer, String description,int quantite) throws ExceptionCustom;

    /**
     * Create item.
     *
     * @param idItemInfo  the id item info
     * @param idContainer the id container
     * @param description the description
     * @return the item
     */
    boolean Create(int idItemInfo, int idContainer, String description,int quantite) throws ExceptionCustom;

    /**
     * Delete item.
     *
     * @param id the id
     * @return the item
     */
    boolean Delete(int id) throws ExceptionCustom;
}
