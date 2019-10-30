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
    public List<User> FindByName(String name) {

        List<User> userList = null;
        try {
            userList = userService.FindByName(name);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return userList;
    }

    @Override
    public boolean Update(short id, String nom, String password, short acces) {

        boolean update = true;

        try {
            update = userService.Update(id,nom,password,acces);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return update;

    }

    @Override
    public boolean Create(short id, String nom, String password, short acces) {

        boolean create = true;

        try {
            create = userService.Create(id,nom,password,acces);
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
