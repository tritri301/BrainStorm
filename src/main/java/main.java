import Controllers.ItemController;
import Factory.ItemFactory;
import Models.Item;
import Repositories.ItemRepository;
import Services.VerificationService;

import java.io.Console;
import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args) {

		ItemRepository itemRepository = ItemRepository.GetInstance();
		ItemFactory itemFactory = ItemFactory.GetInstance();
		VerificationService verif = VerificationService.GetInstance();

		Item item = itemFactory.Create(0, 1, "111-111-111", "item creer sans id",1);
		try {
			//itemRepository.Create(item);
			String string;
			string = "Éèèà!$?&";
			System.out.print(verif.normalisation(string));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
