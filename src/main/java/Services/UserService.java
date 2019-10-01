package Services;

import Factory.UserFactory;
import Models.ConnectionBD;
import Repositories.UserRepository;
import Services.Interfaces.UserServiceInterface;
import Models.User;

import java.util.ArrayList;
import java.util.List;


/**
 * The type User service.
 */
public class UserService implements UserServiceInterface {

    private static final UserService instance = new UserService();
    private UserRepository userRepository = UserRepository.GetInstance();
    private UserFactory itemFactory = UserFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();

    @Override
    public User FindById(int id) {
        User user = null;
        if (connectionBD == null)
        {
            try {
                user = this.userRepository.FindById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return user;
    }

    @Override
    public List<User> FindAll() {
        List<User> user = new ArrayList<User>();
        if (connectionBD == null)
        {
            try {
               // user = this.userRepository.FindAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return new ArrayList<>();
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
