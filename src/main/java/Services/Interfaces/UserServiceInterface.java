package Services.Interfaces;

import Models.User;
import Exception.*;
import java.util.List;

/**
 * The interface User service interface.
 */
public interface UserServiceInterface {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    User FindById(int id) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> FindAll() throws ExceptionCustom;

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    List<User> FindByEmail(String email) throws ExceptionCustom;

    /**
     * Update user.
     *
     * @param id           the id
     * @param nom          the nom
     * @param password     the password
     * @param acces        the acces
     * @return the user
     */
    boolean Update(User userToUpdate) throws ExceptionCustom;

    /**
     * Create user.
     *
     * @param id       the id
     * @param nom      the nom
     * @param password the password
     * @param acces    the acces
     * @return the user
     */
    boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole) throws ExceptionCustom;

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    boolean Delete(int id) throws ExceptionCustom;
}
