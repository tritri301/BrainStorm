package Controllers.Interface;


import Models.Item;

import java.util.List;

public interface ItemControllerInterface
{
    Item FindById(int id);

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

     * @param description the description
     * @return the item
     */
    boolean Update(int idItem, int idItemInfo, String emplacement, String description,int quantite);

    /**
     * Create item.
     *

     * @param idItemInfo  the id item info

     * @param description the description
     * @return the item
     */
    boolean Create(int idItemInfo, String emplacement, String description,int quantite);

    /**
     * Delete item.
     *
     * @param id the id
     * @return the item
     */
    boolean Delete(int id, int quantite);

    boolean MoveItem(int id,int quantite,String emplacementNouveau);

    boolean ModifyItem(int id, String description);


}
