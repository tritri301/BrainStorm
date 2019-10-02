package Services;

import Factory.UserFactory;
import Models.ConnectionBD;
import Repositories.UserRepository;
import Services.Interfaces.UserServiceInterface;
import Models.User;
import Exception.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The type User service.
 */
public class UserService implements UserServiceInterface {

    private static final UserService instance = new UserService();
    private UserRepository userRepository = UserRepository.GetInstance();
    private UserFactory userFactory = UserFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    @Override
    public User FindById(int id) throws ExceptionCustom {
        User user = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    user = this.userRepository.FindById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }else{
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return user;
    }

    @Override
    public List<User> FindAll() {
        List<User> user = new ArrayList<User>();
        if (connection == null)
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
        if (this.verificationService.verifier(name)) {
            if (connection == null) {
                try {
                    user = this.userRepository.FindByName(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }else{
            //donnée entré non valide
        }

        return user;
    }

    @Override
    public boolean Update(short id,String nom,String password,short acces) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(id,acces);
        if (valide)
        {
            valide = this.verificationService.verifier(nom,password);
        }

        if (valide) {
            User nouveauUser = FindById(id);
            nouveauUser.setNom(nom);
            nouveauUser.setPassword(password);
            nouveauUser.setAcces(acces);

            if (connection == null) {
                try {
                    this.userRepository.Update(nouveauUser);
                } catch (Exception e) {
                    valide = false;
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }else{
            //donnée entré non valide
        }

        return valide;
    }

    @Override
    public boolean Create(short id,String nom,String password,short acces) {

        boolean valide = this.verificationService.verifier(id,acces);
        if (valide)
        {
            valide = this.verificationService.verifier(nom,password);
        }

        if(valide) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateCreation = format.format(new Date());

            if (connection == null) {
                try {
                    userRepository.Create(this.userFactory.Create(id, nom, password, dateCreation, acces));
                } catch (Exception e) {
                    valide = false;
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }
        else{
            //donnée entré non valide
        }

        return valide;
    }

    @Override
    public boolean Delete(int id) {

        boolean valide = this.verificationService.verifier(id);

        if (valide) {
            if (connection == null) {
                try {
                    this.userRepository.Delete(id);
                } catch (Exception e) {
                    valide = false;
                    e.printStackTrace();
                }
            } else {
                //erreur de connection BD
            }
        }else{
            //donnée entré non valide
        }

        return valide;
    }

    public static UserService GetInstance()
    {
        return instance;
    }
}
