import Factory.ItemFactory;
import Models.Item;
import Repositories.ItemRepository;

import java.sql.*;

public class main
{
    public static void main(String[] args)
    {
        ItemRepository Repo = ItemRepository.GetInstance();
        ItemFactory Facto = ItemFactory.GetInstance();

        Item item = Facto.Create(1, 1, 1, "Un clou modifié");

        try {
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("The current working directory is " + currentDirectory);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
