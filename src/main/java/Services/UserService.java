package Services;

import Services.Interfaces.UserServiceInterface;
import Models.User;

/**
 * The type User service.
 */
public class UserService implements UserServiceInterface {

    private static final UserService instance = new UserService();
    private UserRepository userRepository = UserRepository.GetInstance();

    @Override
    public User FindById(int id) {
        return null;
    }

    @Override
    public User FindByName(String name) {
        return null;
    }

    @Override
    public User Update(int id) {
        return null;
    }

    @Override
    public User Create() {
        return null;
    }

    @Override
    public User Delete(int id) {
        return null;
    }

    public static UserService GetInstance()
    {
        return instance;
    }
}
