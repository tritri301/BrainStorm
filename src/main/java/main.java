import Controllers.ItemController;
import Controllers.UserController;
import Factory.ItemFactory;
import Models.Item;
import Models.User;
import Repositories.ItemRepository;
import Repositories.UserRepository;
import Services.VerificationService;

import java.io.Console;
import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args) {

		UserController controller = UserController.GetInstance();

		User test = controller.FindById(12);

		test.setPassword("bruh modified");
		test.setEmail("flash2014@nigger.com");

		controller.Update(test);
		//controller.Delete(12);

    }

}