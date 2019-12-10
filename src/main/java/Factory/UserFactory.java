package Factory;

import Models.ConnectedUser;
import Models.User;

/**
 * The type User factory.
 */
public class UserFactory {

    private static final UserFactory instance =new UserFactory();

    public User Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, String lastConnected, String lastPassChange, int unsuccessfullConnection, int idRole){
        User ret = new User();

        ret.setIdUser(idUser);
        ret.setEmail(email);
        ret.setPassword(password);
        ret.setPoste(poste);
        ret.setLastName(lastName);
        ret.setFirstName(firstName);
        ret.setAdresse(adresse);
        ret.setLastConnected(lastConnected);
        ret.setLastPassChange(lastPassChange);
        ret.setUnsuccessfullConnection(unsuccessfullConnection);
        ret.setIdRole(idRole);

        return ret;
    }
    public ConnectedUser CreateConnected(User user)
    {
        ConnectedUser ret = ConnectedUser.GetInstance();

        ret.setIdUser(user.getIdUser());
        ret.setEmail(user.getEmail());
        ret.setPassword(user.getPassword());
        ret.setPoste(user.getPoste());
        ret.setLastName(user.getLastName());
        ret.setFirstName(user.getFirstName());
        ret.setAdresse(user.getAdresse());
        ret.setLastConnected(user.getLastConnected());
        ret.setLastPassChange(user.getLastPassChange());
        ret.setUnsuccessfullConnection(user.getUnsuccessfullConnection());
        ret.setIdRole(user.getIdRole());

        return ret;
    }

    public static UserFactory GetInstance(){return instance;}
}
