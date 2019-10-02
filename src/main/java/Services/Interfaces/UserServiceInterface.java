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
    public User FindById(int id);
    public List<User> FindAll();

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    public List<User> FindByName(String name);

    /**
     * Update user.
     *
     * @param id the id
     * @return the user
     */
    public boolean Update(short id,String nom,String password,String dateCreation,short acces);

    /**
     * Create user.
     *
     * @return the user
     */
    public boolean Create(short id,String nom,String password,String dateCreation,short acces);

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    public boolean Delete(int id);
}
