package Controllers;

import Controllers.Interface.RoleControllerInterface;
import Exception.ExceptionCustom;
import Models.Role;
import Services.RoleService;

/**
 * @Note
 */
public class RoleController implements RoleControllerInterface {
    private static final RoleController instance = new RoleController();
    private RoleService roleService = RoleService.GetInstance();
    @Override
    public Role FindById(int id) {
        Role ret = null;
        try {
            ret = this.roleService.FindById(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return ret;
    }

    @Override
    public void Update(Role roleToUpdate) {
        try {
            this.roleService.Update(roleToUpdate);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
    }

    @Override
    public void Delete(int id) {
        try {
            this.roleService.Delete(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
    }

    @Override
    public Role Create(String permissions, String roleName) {
        Role ret = null;
        try {
            ret = this.roleService.Create(permissions, roleName);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return ret;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RoleController getInstance()
    {
        return instance;
    }
}
