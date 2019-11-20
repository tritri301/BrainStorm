package Factory;

import Models.User;

/**
 * The type User factory.
 */
public class UserFactory {

    private static final UserFactory instance =new UserFactory();

    public User Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole){
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

    public static UserFactory GetInstance(){return instance;}
}
