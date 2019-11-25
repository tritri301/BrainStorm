package Factory;

import Models.Role;

public class RoleFactory {
    private static final RoleFactory instance = new RoleFactory();

    public Role Create(int idRole, String permissions, String roleName)
    {
        Role ret = new Role();

        ret.setIdRole(idRole);
        ret.setPermissions(permissions);
        ret.setRoleName(roleName);

        return ret;
    }

    public static RoleFactory GetInstance(){
        return instance;
    }
}
