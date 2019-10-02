package Factory;

import Models.User;

/**
 * The type User factory.
 */
public class UserFactory {

    private static final UserFactory instance =new UserFactory();

    public User Create(short id,String nom,String password,String dateCreation,short acces){
        User ret = new User();

        ret.setIdUser(id);
        ret.setNom(nom);
        ret.setPassword(password);
        ret.setDateCreation(dateCreation);
        ret.setAcces(acces);

        return ret;
    }

    public static UserFactory GetInstance(){return instance;}
}
