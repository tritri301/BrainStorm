package Controllers.Interface;

import Models.Role;
import Services.RoleService;
import Exception.*;

public interface RoleControllerInterface {
    Role FindById(int id);
    void Update(Role roleToUpdate);
    void Delete(int id);
    Role Create(String permissions, String roleName);


}
