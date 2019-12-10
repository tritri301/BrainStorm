package Models;

/**
 * The type Role.
 */
public class Role {
    private int idRole;
    private String permission;
    private String roleName;

    /**
     * Gets id role.
     *
     * @return the id role
     */
    public int getIdRole() {
        return idRole;
    }

    /**
     * Sets id role.
     *
     * @param idRole the id role
     */
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    /**
     * Gets permissions.
     *
     * @return the permissions
     */
    public String getPermissions() {
        return permission;
    }

    /**
     * Sets permissions.
     *
     * @param permission the permission
     */
    public void setPermissions(String permission) {
        this.permission = permission;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
