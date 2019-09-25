package Services.Interfaces;

import Models.User;

public interface UserServiceInterface {
    public User FindById(int id);
    public User FindByName(String name);
    public User Update(int id);
    public User Create();
    public User Delete(int id);
}
