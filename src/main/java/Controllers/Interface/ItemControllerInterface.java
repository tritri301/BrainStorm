package Controllers.Interface;


import Models.Item;

import java.util.List;

/**
 * The interface Item controller interface.
 */
public interface ItemControllerInterface
{
    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    Item FindById(int id);

    /**
     * Trouver similaire item.
     *
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @return the item
     */
    Item trouverSimilaire(int idItemInfo,String emplacement,String description);

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    int FindAmountById(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Item> FindAll();

    /**
     * Sort by name list.
     *
     * @return the list
     */
    List<Item> SortByName();

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
     * @param emplacement the emplacement
     * @param description the description
     * @param quantite    the quantite
     * @return the item
     */
    boolean Update(int idItem, int idItemInfo, String emplacement, String description,int quantite);

    /**
     * Create item.
     *
     * @param idItemInfo  the id item info
     * @param emplacement the emplacement
     * @param description the description
     * @param quantite    the quantite
     * @return the item
     */
    boolean Create(int idItemInfo, String emplacement, String description,int quantite);

    /**
     * Delete item.
     *
     * @param id       the id
     * @param quantite the quantite
     * @return the item
     */
    boolean Delete(int id, int quantite);

    /**
     * Move item boolean.
     *
     * @param id                 the id
     * @param quantite           the quantite
     * @param emplacementNouveau the emplacement nouveau
     * @return the boolean
     */
    boolean MoveItem(int id,int quantite,String emplacementNouveau);

    /**
     * Modify item boolean.
     *
     * @param id          the id
     * @param description the description
     * @return the boolean
     */
    boolean ModifyItem(int id, String description);


}
