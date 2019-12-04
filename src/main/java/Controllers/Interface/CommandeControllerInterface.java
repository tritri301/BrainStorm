package Controllers.Interface;

import Models.Commande;

import java.sql.Date;
import java.util.List;

/**
 * The interface Commande controller interface.
 */
public interface CommandeControllerInterface {
    /**
     * Find by id commande.
     *
     * @param id the id
     * @return the commande
     */
    Commande FindById(int id);

    /**
     * Find by id item commande.
     *
     * @param id the id
     * @return the commande
     */
    Commande FindByIdItem(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Commande> FindAll();

    /**
     * Update boolean.
     *
     * @param idCommande the id commande
     * @param etat       the etat
     * @param nomPRecu   the nom p recu
     * @return the boolean
     */
    boolean Update(int idCommande, int etat, String nomPRecu);

    /**
     * Create int.
     *
     * @param nomPEnvoi the nom p envoi
     * @return the int
     */
    int Create(String nomPEnvoi);
}
