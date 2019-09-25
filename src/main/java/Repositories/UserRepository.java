package Repositories;

import Repositories.Interfaces.UserRepositoryInterface;
import models.User;

public class UserRepository implements UserRepositoryInterface {
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
}
