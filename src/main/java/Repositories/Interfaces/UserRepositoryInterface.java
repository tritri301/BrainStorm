package Repositories.Interfaces;

import Models.User;

import java.util.List;

/**
 * The interface User repository interface.
 */
public interface UserRepositoryInterface {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     * @throws Exception the exception
     */
    User FindById(int id) throws Exception;

    /**
     * Find by email list.
     *
     * @param name the name
     * @return the list
     * @throws Exception the exception
     */
    List<User> FindByEmail(String name) throws Exception;

    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<User> FindAll() throws Exception;

    /**
     * Update.
     *
     * @param itemToUpdate the item to update
     * @throws Exception the exception
     */
    void Update(User itemToUpdate) throws Exception;

    /**
     * Delete.
     *
     * @param id the id
     * @throws Exception the exception
     */
    void Delete(int id) throws Exception;

    /**
     * Create.
     *
     * @param itemToAdd the item to add
     * @throws Exception the exception
     */
    void Create(User itemToAdd) throws Exception;
}
