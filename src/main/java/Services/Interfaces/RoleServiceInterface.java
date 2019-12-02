package Services.Interfaces;

import Models.Role;

public interface RoleServiceInterface {
    Role FindById(int id) throws Exception;
    void Update(Role roleToUpdate) throws Exception;
    void Delete(int id) throws Exception;
    Role Create(String permissions, String roleName) throws Exception;
}
