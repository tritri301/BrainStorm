package Repositories.Interfaces;

import Models.ItemCommande;

import java.util.List;

/**
 * The interface Item commande repository interface.
 */
public interface ItemCommandeRepositoryInterface {
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
     * Update.
     *
     * @param ItemCommandeToUpdate the item commande to update
     * @throws Exception the exception
     */
    void Update(ItemCommande ItemCommandeToUpdate) throws Exception;

    /**
     * Create.
     *
     * @param ItemCommandeToAdd the item commande to add
     * @throws Exception the exception
     */
    void Create(ItemCommande ItemCommandeToAdd) throws Exception;
}
