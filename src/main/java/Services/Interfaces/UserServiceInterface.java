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
    List<User> FindByName(String name) throws ExceptionCustom;

    /**
     * Update user.
     *
     * @param id           the id
     * @param nom          the nom
     * @param password     the password
     * @param acces        the acces
     * @return the user
     */
    boolean Update(short id,String nom,String password,short acces) throws ExceptionCustom;

    /**
     * Create user.
     *
     * @param id       the id
     * @param nom      the nom
     * @param password the password
     * @param acces    the acces
     * @return the user
     */
    boolean Create(short id,String nom,String password,short acces) throws ExceptionCustom;

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    boolean Delete(int id) throws ExceptionCustom;
}
