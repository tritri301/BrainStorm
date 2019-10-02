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
    private UserFactory userFactory = UserFactory.GetInstance();
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
    public List<User> FindByName(String name) {
        List<User> user = new ArrayList<User>();
        if (connectionBD.GetConnectionStatus() == null)
        {
            try {
                user = this.userRepository.FindByName(name);
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
    public boolean Update(short id,String nom,String password,String dateCreation,short acces) {
        boolean valide = true;

        //verification

        User nouveauUser = FindById(id);
        nouveauUser.setIdUser(id);

        if (connectionBD == null)
        {
            try {
                this.userRepository.Update(nouveauItem);
            } catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    @Override
    public boolean Create(short id,String nom,String password,String dateCreation,short acces) {
        boolean valide = true;

        //verification

        if (connectionBD == null)
        {
            try {
                userRepository.Create(this.userFactory.Create(id,nom,password,dateCreation,acces));
            }catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    @Override
    public boolean Delete(int id) {
        boolean valide = true;

        if (connectionBD == null)
        {
            try {
                this.userRepository.Delete(id);
            } catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    public static UserService GetInstance()
    {
        return instance;
    }
}
