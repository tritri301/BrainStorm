package Controllers.Interface;

import Models.User;

import java.util.List;

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
     * @param acces        the acces
     * @return the user
     */
    boolean Update(short id, String nom, String password, short acces);

    /**
     * Create user.
     *
     * @param id       the id
     * @param nom      the nom
     * @param password the password
     * @param acces    the acces
     * @return the user
     */
    boolean Create(short id, String nom, String password, short acces);

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    boolean Delete(int id);
}
