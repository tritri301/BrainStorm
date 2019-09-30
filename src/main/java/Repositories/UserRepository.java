package Repositories;

import Repositories.Interfaces.UserRepositoryInterface;
import Models.User;

public class UserRepository implements UserRepositoryInterface {
    private static final UserRepository instance = new UserRepository();
    @Override
    public User FindById(int id) {
        return null;
    }

    @Override
    public User[] FindAll() {
        return new User[0];
    }

    @Override
    public boolean Update(int id) {
        return false;
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }

    @Override
    public User Create(User UserToAdd) {
        return null;
    }
    public static UserRepository GetInstance() {
        return instance;
    }
}
