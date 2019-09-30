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

        Item newItem = Facto.Create(1, 1, 1, "test");

        try {
            System.out.println(Repo.FindById(1).getDescription());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
