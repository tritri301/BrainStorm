package Repositories.Interfaces;

import Models.Role;

public interface RoleRepositoryInterface {
    Role FindById(int id) throws Exception;
    void Update(Role roleToUpdate) throws Exception;
    void Delete(int id) throws Exception;
    Role Create(Role roleToAdd) throws Exception;
}
