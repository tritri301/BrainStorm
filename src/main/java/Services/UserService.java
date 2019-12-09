package Services;

import Factory.UserFactory;
import Models.ConnectedUser;
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
    private HashService hashService = HashService.getInstance();
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
                    if(!userToUpdate.getPassword().equals(userRepository.FindById(userToUpdate.getIdUser()).getPassword()))
                    {
                        //if the password was changed hash the new password
                        userToUpdate.setPassword(hashService.HashString(userToUpdate.getPassword()));
                    }
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
    public boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, String lastConnected, String lastPassChange, int unsuccessfullConnection, int idRole) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idUser);
        if (valide)
        {
            valide = this.verificationService.verifierEmail(email);
        }

        if(valide) {
            email = email.toLowerCase();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateCreation = format.format(new Date());
            password = hashService.HashString(password);
            if (connection == null) {
                try {
                    userRepository.Create(this.userFactory.Create(idUser, email, password, poste, lastName, firstName, adresse, lastConnected, lastPassChange, unsuccessfullConnection, idRole));
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
    public boolean ConnectUser(String email, String password) throws ExceptionCustom
    {
        User userToConnect = this.FindByEmail(email).get(0);
        int tries = userToConnect.getUnsuccessfullConnection();
        if(!(userToConnect.getPassword().equals(hashService.HashString(password)) && tries <= 3))
        {
            //Sets the ammount of tries the user has
            userToConnect.setUnsuccessfullConnection(tries + 1);
            this.Update(userToConnect);
            return false;
        }
        //Sets the ammount of try back to zero
        userToConnect.setUnsuccessfullConnection(0);
        this.Update(userToConnect);

        //Creates a connected user
        ConnectedUser connectedUser = this.userFactory.CreateConnected(userToConnect);

        //returns if the user has been connected succesfully
        return true;
    }

    public static UserService GetInstance()
    {
        return instance;
    }
}
