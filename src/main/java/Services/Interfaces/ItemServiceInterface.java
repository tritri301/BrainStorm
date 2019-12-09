package Services.Interfaces;

import Exception.ExceptionCustom;
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
     * @throws ExceptionCustom the exception custom
     */
    Item FindById(int id) throws ExceptionCustom;

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     * @throws ExceptionCustom the exception custom
     */
    int FindAmountById(int id) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
    List<Item> FindAll() throws ExceptionCustom;

    /**
     * Sort by name list.
     *
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
    List<Item> SortByName() throws ExceptionCustom;

    /**
     * Find by name item.
     *
     * @param name the name
     * @return the item
     * @throws ExceptionCustom the exception custom
     */
    List<Item> FindByName(String name) throws ExceptionCustom;

    /**
     * Update item.
     *
     * @param idItem      the id item
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @param quantite    the quantite
     * @return the item
     * @throws ExceptionCustom the exception custom
     */
    boolean Update(int idItem, int idItemInfo, String emplacement, String description, int quantite) throws ExceptionCustom;

    /**
     * Create item.
     *
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @param quantite    the quantite
     * @return the item
     * @throws ExceptionCustom the exception custom
     */
    boolean Create(int idItemInfo, String emplacement, String description, int quantite) throws ExceptionCustom;

    /**
     * Delete item.
     *
     * @param id       the id
     * @param quantite the quantite
     * @return the item
     * @throws ExceptionCustom the exception custom
     */
    boolean Delete(int id, int quantite) throws ExceptionCustom;

    /**
     * Move item boolean.
     *
     * @param id                 the id
     * @param quantite           the quantite
     * @param emplacementNouveau the emplacement nouveau
     * @return the boolean
     * @throws ExceptionCustom the exception custom
     */
    boolean MoveItem(int id, int quantite, String emplacementNouveau) throws ExceptionCustom;

    /**
     * Modify item boolean.
     *
     * @param id          the id
     * @param description the description
     * @return the boolean
     * @throws ExceptionCustom the exception custom
     */
    boolean ModifyItem(int id, String description) throws ExceptionCustom;

    /**
     * Trouver similaire item.
     *
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @return the item
     */
    Item trouverSimilaire(int idItemInfo, String emplacement, String description);

    /**
     * Trouver similaire item.
     *
     * @param idItemInfo  the id item info
     * @param description the description
     * @return the item
     */
    Item trouverSimilaire(int idItemInfo, String description);
}
