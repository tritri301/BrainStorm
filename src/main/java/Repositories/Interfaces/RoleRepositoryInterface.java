package Repositories.Interfaces;

import Models.Role;

/**
 * The interface Role repository interface.
 */
public interface RoleRepositoryInterface {
    /**
     * Find by id role.
     *
     * @param id the id
     * @return the role
     * @throws Exception the exception
     */
    Role FindById(int id) throws Exception;

    /**
     * Update.
     *
     * @param roleToUpdate the role to update
     * @throws Exception the exception
     */
    void Update(Role roleToUpdate) throws Exception;

    /**
     * Delete.
     *
     * @param id the id
     * @throws Exception the exception
     */
    void Delete(int id) throws Exception;

    /**
     * Create role.
     *
     * @param roleToAdd the role to add
     * @return the role
     * @throws Exception the exception
     */
    Role Create(Role roleToAdd) throws Exception;
}
