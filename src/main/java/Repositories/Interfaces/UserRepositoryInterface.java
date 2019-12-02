package Repositories.Interfaces;

import Models.User;

import java.util.List;

public interface UserRepositoryInterface {
    User FindById(int id) throws Exception;
    List<User> FindByEmail(String name) throws Exception;
    List<User> FindAll() throws Exception;
    void Update(User itemToUpdate) throws Exception;
    void Delete(int id) throws Exception;
    void Create(User itemToAdd) throws Exception;
}
