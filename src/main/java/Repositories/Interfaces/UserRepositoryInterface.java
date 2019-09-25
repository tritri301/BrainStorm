package Repositories.Interfaces;

import models.User;

public interface UserRepositoryInterface {
    User FindById(int id);
    User[] FindAll();
    boolean Update(int id);
    boolean Delete(int id);
    User Create(User UserToAdd);
}
