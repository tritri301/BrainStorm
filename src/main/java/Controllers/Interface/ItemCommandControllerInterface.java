package Controllers.Interface;

import Models.ItemCommande;

import java.util.List;

/**
 * The interface Item command controller interface.
 */
public interface ItemCommandControllerInterface {
    /**
     * Find by id item commande.
     *
     * @param id the id
     * @return the item commande
     * @throws Exception the exception
     */
    ItemCommande FindById(int id) throws Exception;

    /**
     * Find by id commande list.
     *
     * @param idCommande the id commande
     * @return the list
     */
    List<ItemCommande> FindByIdCommande(int idCommande);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ItemCommande> FindAll();

    /**
     * Update boolean.
     *
     * @param idItemCommande the id item commande
     * @param idCommande     the id commande
     * @param idItemInfo     the id item info
     * @param description    the description
     * @param quantite       the quantite
     * @return the boolean
     */
    boolean Update(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite);

    /**
     * Create boolean.
     *
     * @param idItemCommande the id item commande
     * @param idCommande     the id commande
     * @param idItemInfo     the id item info
     * @param description    the description
     * @param quantite       the quantite
     * @return the boolean
     */
    boolean Create(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite);
}
