import Controllers.CommandeController;
import Controllers.ItemController;
import Factory.CommandeFactory;
import Factory.ItemFactory;
import Models.Commande;
import Models.Item;
import Models.ItemCommande;
import Repositories.CommandeRepository;
import Repositories.ItemRepository;
import Services.CommandeService;
import Services.ItemCommandeService;
import Services.ItemService;
import Services.VerificationService;

import java.io.Console;
import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args) {

		ItemRepository itemRepository = ItemRepository.GetInstance();
		ItemService itemService = ItemService.GetInstance();
		ItemFactory itemFactory = ItemFactory.GetInstance();
		VerificationService verif = VerificationService.GetInstance();

		CommandeRepository commandeRepository = CommandeRepository.GetInstance();
		CommandeFactory commandeFactory = CommandeFactory.GetInstance();
		CommandeService commandeService = CommandeService.GetInstance();
		ItemCommandeService itemCommandeService = ItemCommandeService.GetInstance();


		Commande commande = null;

		int idItem = 259;
		String description;
		int quantite = 100;
		String emplacement = "R0-E0-T0";

		try {
			//itemCommandeService.Create(1,1,1,"test",1);
			int id = 0;

			id = commandeService.Create("boby");
			System.out.println("Voici l'id generer : "+id);

		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}