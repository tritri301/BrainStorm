import Controllers.CommandeController;
import Controllers.ItemController;
import Factory.CommandeFactory;
import Factory.ItemFactory;
import Models.Commande;
import Models.Container;
import Models.Item;
import Models.ItemCommande;
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

				String host="10.20.40.40";
				String user="pi";
				String password="raspberry";
				String command1="mysqldump --routines -u BrainStorm -pinfo420 EquipeTristan_BD";
				try{

					java.util.Properties config = new java.util.Properties();
					config.put("StrictHostKeyChecking", "no");
					JSch jsch = new JSch();
					Session session=jsch.getSession(user, host, 22);
					session.setPassword(password);
					session.setConfig(config);
					session.connect();
					System.out.println("Connected");

					Channel channel=session.openChannel("exec");
					((ChannelExec)channel).setCommand(command1);
					channel.setInputStream(null);
					((ChannelExec)channel).setErrStream(System.err);

					InputStream in=channel.getInputStream();
					channel.connect();
					byte[] tmp=new byte[1024];
					while(true){
						while(in.available()>0){
							int i=in.read(tmp, 0, 1024);
							if(i<0)break;
							System.out.print(new String(tmp, 0, i));
						}
						if(channel.isClosed()){
							System.out.println("exit-status: "+channel.getExitStatus());
							break;
						}
						try{Thread.sleep(1000);}catch(Exception ee){}
					}
					channel.disconnect();
					session.disconnect();
					System.out.println("DONE");
				}catch(Exception e){
					e.printStackTrace();
				}


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
