package Factory;

import Models.User;

public class UserFactory {
    private User create(short id,String nom,String password,String dateCreation,short acces){
        User ret = new User();

        ret.setIdUser(id);
        ret.setNom(nom);
        ret.setPassword(password);
        ret.setDateCreation(dateCreation);
        ret.setAcces(acces);

        return ret;
    }
}
