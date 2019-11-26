import Controllers.ItemController;
import Controllers.RoleController;
import Controllers.UserController;
import Factory.ItemFactory;
import Models.Item;
import Models.Role;
import Models.User;
import Repositories.ItemRepository;
import Repositories.UserRepository;
import Services.HashService;
import Services.VerificationService;

import java.io.Console;
import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args) {

		UserController controller = UserController.GetInstance();
		HashService hashService = HashService.getInstance();

		controller.Create(166, "test@test.com", "password", null, "coudé", "Tristan", null, 1);

		//Role test = controller.Create("11111111111111111111111111111111", "Admin");
		//System.out.println(test.getRoleName());
    }

}