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
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("L'usager recherché est introuvable");
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
    public List<User> FindAll() throws ExceptionCustom {
        List<User> user = new ArrayList<User>();
        if (connection == null)
        {
            try {
                user = this.userRepository.FindAll();
                if (user == null)
                {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                    throw exceptionErreurBD;
                }
            } catch (Exception e) {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                throw exceptionErreurBD;
            }
        }
        else
        {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
            throw exceptionErreurBD;
        }

        return new ArrayList<>();
    }

    @Override
    public List<User> FindByEmail(String email) throws ExceptionCustom {
        List<User> user = new ArrayList<User>();
        if (this.verificationService.verifierEmail(email)) {
            if (connection == null) {
                try {
                    email = email.toLowerCase();
                    user = this.userRepository.FindByEmail(email);
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("L'usager recherché est introuvable");
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
    public boolean Update(User userToUpdate) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(userToUpdate.getIdUser());
        if (valide)
        {
            valide = this.verificationService.verifierEmail(userToUpdate.getEmail());
        }

        if (valide) {
            userToUpdate.setEmail(userToUpdate.getEmail().toLowerCase());

            if (connection == null) {
                try {
                    this.userRepository.Update(userToUpdate);
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    @Override
    public boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idUser);
        if (valide)
        {
            valide = this.verificationService.verifierEmail(email);
        }

        if(valide) {
            email = email.toLowerCase();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateCreation = format.format(new Date());

            if (connection == null) {
                try {
                    userRepository.Create(this.userFactory.Create(idUser, email, password, poste, lastName, firstName, adresse, idRole));
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }
        else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    @Override
    public boolean Delete(int id) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(id);

        if (valide) {
            if (connection == null) {
                try {
                    this.userRepository.Delete(id);
                } catch (Exception e) {
                    valide = false;
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("L'usager recherché est introuvable");
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        }else{
            valide = false;
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return valide;
    }

    public static UserService GetInstance()
    {
        return instance;
    }
}
