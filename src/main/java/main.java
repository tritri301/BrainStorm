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
		//try {
		//	String string = "Éèèà!$?&";
			//String string = "847-232-213";
		//	System.out.print(verif.normalisation(string));
		//} catch (Exception e) {
		//	e.printStackTrace();

		//etstst

		String emplacement = "R0-E0-T0";

		//tester normaliser

		if (verif.emplacementVerification(emplacement))
		{
			System.out.print("emplacement existant !!!!");
		}
		else
		{
			System.out.print("n'existe PAS !!!");
		}
    }

}