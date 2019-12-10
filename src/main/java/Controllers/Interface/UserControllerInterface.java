package Controllers.Interface;

import Models.User;

import java.util.List;

/**
 * The interface User controller interface.
 */
public interface UserControllerInterface {

    /**
     * Find by id user.
     *
     * @param id the iijijid
     * @return the user
     */
    User FindById(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> FindAll();

    /**
     * Find by name user.
     *
     * @param email the email
     * @return the user
     */
    List<User> FindByEmail(String email);

    /**
     * Update user.
     *
     * @param userToUpdate the user to update
     * @return the user
     */
    boolean Update(User userToUpdate);

    /**
     * Create user.
     *
     * @param idUser    the id user
     * @param email     the email
     * @param password  the password
     * @param poste     the poste
     * @param lastName  the last name
     * @param firstName the first name
     * @param adresse   the adresse
     * @param idRole    the id role
     * @return the user
     */
    boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, String lastConnected, String lastPassChange, int unsuccessfullConnection, int idRole);

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    boolean Delete(int id);
}
