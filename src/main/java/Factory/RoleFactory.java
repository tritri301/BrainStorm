package Factory;

import Models.Role;

/**
 * The type Role factory.
 */
public class RoleFactory {
    private static final RoleFactory instance = new RoleFactory();

    /**
     * Get instance role factory.
     *
     * @return the role factory
     */
    public static RoleFactory GetInstance() {
        return instance;
    }

    /**
     * Create role.
     *
     * @param idRole      the id role
     * @param permissions the permissions
     * @param roleName    the role name
     * @return the role
     */
    public Role Create(int idRole, String permissions, String roleName) {
        Role ret = new Role();

        ret.setIdRole(idRole);
        ret.setPermissions(permissions);
        ret.setRoleName(roleName);

        return ret;
    }
}
