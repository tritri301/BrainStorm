package Controllers;

import Controllers.Interface.UserControllerInterface;
import Models.User;
import Services.UserService;
import java.util.List;
import Exception.*;
//test
public class UserController implements UserControllerInterface {

      private static final UserController instance = new UserController();
      private UserService userService = UserService.GetInstance();

        //testid
    @Override
    public User FindById(int id) {

        User user =  null;
        try {
            user = userService.FindById(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return user;
    }

    @Override
    public List<User> FindAll() {

        List<User> itemUser = null;

        try {
            itemUser = userService.FindAll();
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return itemUser;
    }

    @Override
    public List<User> FindByEmail(String email) {

        List<User> userList = null;
        try {
            userList = userService.FindByEmail(email);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return userList;
    }

    @Override
    public boolean Update(User userToUpdate) {

        boolean update = true;

        try {
            update = userService.Update(userToUpdate);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return update;

    }

    @Override
    public boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole) {

        boolean create = true;

        try {
            create = userService.Create(idUser, email, password, poste, lastName, firstName, adresse, idRole);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return create;

    }

    @Override
    public boolean Delete(int id) {

        boolean delete = true;
        try {
            delete = userService.Delete(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return delete;
    }

    public static UserController GetInstance()
    {
        return instance;
    }
}
