package Services.Interfaces;

import Models.User;

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
     * @param name the name
     * @return the user
     */
    List<User> FindByName(String name);

    /**
     * Update user.
     *
     * @param id           the id
     * @param nom          the nom
     * @param password     the password
     * @param dateCreation the date creation
     * @param acces        the acces
     * @return the user
     */
    boolean Update(short id,String nom,String password,String dateCreation,short acces);

    /**
     * Create user.
     *
     * @param id           the id
     * @param nom          the nom
     * @param password     the password
     * @param dateCreation the date creation
     * @param acces        the acces
     * @return the user
     */
    boolean Create(short id,String nom,String password,short acces);

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    boolean Delete(int id);
}
