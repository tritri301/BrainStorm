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
            Item newItem = Repo.FindByName("Clou").get(0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
