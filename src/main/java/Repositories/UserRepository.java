package Repositories;

import Repositories.Interfaces.UserRepositoryInterface;
import Models.User;

import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    private static final UserRepository instance = new UserRepository();

    @Override
    public User FindById(int id) throws Exception {
        return null;
    }

    @Override
    public List<User> FindByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<User> FindAll() throws Exception {
        return null;
    }

    @Override
    public void Update(User itemToUpdate) throws Exception {

    }

    @Override
    public void Delete(int id) throws Exception {

    }

    @Override
    public void Create(User itemToAdd) throws Exception {

    }

    public static UserRepository GetInstance() {
        return instance;
    }
}
