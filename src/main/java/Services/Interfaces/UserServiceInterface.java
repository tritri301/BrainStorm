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
    public User FindByName(String name);

    /**
     * Update user.
     *
     * @param id the id
     * @return the user
     */
    public User Update(int id);

    /**
     * Create user.
     *
     * @return the user
     */
    public User Create();

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     */
    public User Delete(int id);
}
