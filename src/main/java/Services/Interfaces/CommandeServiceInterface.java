package Services.Interfaces;

import Models.Commande;

import java.util.List;

/**
 * The interface Commande service interface.
 */
public interface CommandeServiceInterface {
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
     * Update boolean.
     *
     * @param idCommande the id commande
     * @param etat       the etat
     * @param nomPRecu   the nom p recu
     * @return the boolean
     * @throws Exception the exception
     */
    boolean Update(int idCommande, int etat, String nomPRecu) throws Exception;

    /**
     * Create int.
     *
     * @param nomPEnvoi the nom p envoi
     * @return the int
     * @throws Exception the exception
     */
    int Create(String nomPEnvoi) throws Exception;
}
