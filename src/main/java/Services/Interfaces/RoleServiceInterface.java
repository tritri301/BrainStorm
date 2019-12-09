package Services.Interfaces;

import Models.Role;

/**
 * The interface Role service interface.
 */
public interface RoleServiceInterface {
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
     * @param permissions the permissions
     * @param roleName    the role name
     * @return the role
     * @throws Exception the exception
     */
    Role Create(String permissions, String roleName) throws Exception;
}
