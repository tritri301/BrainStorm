package Services.Interfaces;

import Models.ItemCommande;

import java.util.List;

/**
 * The interface Item commande service interface.
 */
public interface ItemCommandeServiceInterface {
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
     * @throws Exception the exception
     */
    List<ItemCommande> FindByIdCommande(int idCommande) throws Exception;

    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<ItemCommande> FindAll() throws Exception;

    /**
     * Update boolean.
     *
     * @param idItemCommande the id item commande
     * @param idCommande     the id commande
     * @param idItemInfo     the id item info
     * @param description    the description
     * @param quantite       the quantite
     * @return the boolean
     * @throws Exception the exception
     */
    boolean Update(int idItemCommande, int idCommande, int idItemInfo, String description, int quantite) throws Exception;

    /**
     * Create boolean.
     *
     * @param idItemCommande the id item commande
     * @param idCommande     the id commande
     * @param idItemInfo     the id item info
     * @param description    the description
     * @param quantite       the quantite
     * @return the boolean
     * @throws Exception the exception
     */
    boolean Create(int idItemCommande, int idCommande, int idItemInfo, String description, int quantite) throws Exception;
}
