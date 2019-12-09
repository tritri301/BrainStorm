package Repositories.Interfaces;

import Models.Commande;

import java.util.List;

/**
 * The interface Commande repository interface.
 */
public interface CommandeRepositoryInterface {
    /**
     * Find by id commande.
     *
     * @param id the id
     * @return the commande
     * @throws Exception the exception
     */
    Commande FindById(int id) throws Exception;

    /**
     * Find by id item commande.
     *
     * @param id the id
     * @return the commande
     * @throws Exception the exception
     */
    Commande FindByIdItem(int id) throws Exception;

    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<Commande> FindAll() throws Exception;

    /**
     * Update.
     *
     * @param commandeToUpdate the commande to update
     * @throws Exception the exception
     */
    void Update(Commande commandeToUpdate) throws Exception;

    /**
     * Create int.
     *
     * @param commandeToAdd the commande to add
     * @return the int
     * @throws Exception the exception
     */
    int Create(Commande commandeToAdd) throws Exception;
}
