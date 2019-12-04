package Controllers.Interface;

import Models.Role;
import Services.RoleService;
import Exception.*;

/**
 * The interface Role controller interface.
 */
public interface RoleControllerInterface {
    /**
     * Find by id role.
     *
     * @param id the id
     * @return the role
     */
    Role FindById(int id);

    /**
     * Update.
     *
     * @param roleToUpdate the role to update
     */
    void Update(Role roleToUpdate);

    /**
     * Delete.
     *
     * @param id the id
     */
    void Delete(int id);

    /**
     * Create role.
     *
     * @param permissions the permissions
     * @param roleName    the role name
     * @return the role
     */
    Role Create(String permissions, String roleName);


}
