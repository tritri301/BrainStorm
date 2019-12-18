import Controllers.CommandeController;
import Controllers.ItemController;
import Factory.CommandeFactory;
import Factory.ItemFactory;
import Models.Commande;
import Models.Container;
import Models.Item;
import Models.ItemCommande;
import Repositories.BackupRepository;
import Repositories.CommandeRepository;
import Repositories.ItemRepository;
import Services.*;
import Exception.*;

import java.io.Console;
import java.sql.*;
import java.util.List;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class main
{
    public static void main(String[] args) throws ExceptionCustom {

		ItemRepository itemRepository = ItemRepository.GetInstance();
		ItemService itemService = ItemService.GetInstance();
		ContainerService containerService = ContainerService.GetInstance();
		ItemFactory itemFactory = ItemFactory.GetInstance();
		VerificationService verif = VerificationService.GetInstance();

		CommandeRepository commandeRepository = CommandeRepository.GetInstance();
		CommandeFactory commandeFactory = CommandeFactory.GetInstance();
		CommandeService commandeService = CommandeService.GetInstance();
		ItemCommandeService itemCommandeService = ItemCommandeService.GetInstance();

		BackupRepository backup = new BackupRepository();
		System.out.print(backup.FindAll().get(0));


			System.out.println("---------------TEST SIMON --------------------------");

			//itemService.Create(1,"R0-E0-T0","testPoids2",500);
			//itemService.Create(1,"R0-E0-T1","testPoids2",500);
			//itemService.Delete(27,70);
			//itemService.ModifyItem(27,"la modification fonctionne");
			//itemService.MoveItem(27,20,"R0-E0-T2");
			//itemService.MoveItem(29,10,"R0-E0-T3");
			//itemService.MoveItem(29,20,"R0-E0-T4");
	}

		}
