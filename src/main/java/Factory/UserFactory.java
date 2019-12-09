package Factory;

import Models.ConnectedUser;
import Models.User;

/**
 * The type User factory.
 */
public class UserFactory {

    private static final UserFactory instance = new UserFactory();

    /**
     * Get instance user factory.
     *
     * @return the user factory
     */
    public static UserFactory GetInstance() {
        return instance;
    }

    /**
     * Create user.
     *
     * @param idUser    the id user
     * @param email     the email
     * @param password  the password
     * @param poste     the poste
     * @param lastName  the last name
     * @param firstName the first name
     * @param adresse   the adresse
     * @param idRole    the id role
     * @return the user
     */
    public User Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole) {
        User ret = new User();

        ret.setIdUser(idUser);
        ret.setEmail(email);
        ret.setPassword(password);
        ret.setPoste(poste);
        ret.setLastName(lastName);
        ret.setFirstName(firstName);
        ret.setAdresse(adresse);
        ret.setIdRole(idRole);

        return ret;
    }

    /**
     * Create connected connected user.
     *
     * @param user the user
     * @return the connected user
     */
    public ConnectedUser CreateConnected(User user) {
        ConnectedUser ret = ConnectedUser.GetInstance();

        ret.setIdUser(user.getIdUser());
        ret.setEmail(user.getEmail());
        ret.setPassword(user.getPassword());
        ret.setPoste(user.getPoste());
        ret.setLastName(user.getLastName());
        ret.setFirstName(user.getFirstName());
        ret.setAdresse(user.getAdresse());
        ret.setIdRole(user.getIdRole());

        return ret;
    }
}
