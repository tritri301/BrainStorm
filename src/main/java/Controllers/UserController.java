package Controllers;

import Controllers.Interface.UserControllerInterface;
import Models.User;
import Services.UserService;
import java.util.List;
import Exception.*;
import View.Browser;

//test
public class UserController implements UserControllerInterface {

      private static final UserController instance = new UserController();
      private UserService userService = UserService.GetInstance();
    private Browser browser = Browser.GetInstance();

        //testid
    @Override
    public User FindById(int id) {

        User user =  null;
        try {
            user = userService.FindById(id);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return user;
    }

    @Override
    public List<User> FindAll() {

        List<User> itemUser = null;

        try {
            itemUser = userService.FindAll();
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return itemUser;
    }

    @Override
    public List<User> FindByEmail(String email) {

        List<User> userList = null;
        try {
            userList = userService.FindByEmail(email);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return userList;
    }

    @Override
    public boolean Update(User userToUpdate) {

        boolean update = true;

        try {
            update = userService.Update(userToUpdate);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return update;

    }

    @Override
    public boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, String lastConnected, String lastPassChange, int unsuccessfullConnection, int idRole) {

        boolean create = true;

        try {
            create = userService.Create(idUser, email, password, poste, lastName, firstName, adresse, lastConnected, lastPassChange, unsuccessfullConnection, idRole);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }

        return create;

    }

    @Override
    public boolean Delete(int id) {

        boolean delete = true;
        try {
            delete = userService.Delete(id);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }

        return delete;
    }
    public boolean ConnectUser(String email, String password)
    {
        boolean connected = true;
        try{
            connected = this.userService.ConnectUser(email, password);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return connected;
    }

    public static UserController GetInstance()
    {
        return instance;
    }
}
