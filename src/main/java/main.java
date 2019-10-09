import Controllers.ItemController;
import Factory.ItemFactory;
import Models.Item;
import Repositories.ItemRepository;
import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        ItemRepository itemRepository = ItemRepository.GetInstance();
        ItemFactory itemFactory = ItemFactory.GetInstance();

        Item item = itemFactory.Create(0,1,1,"item creer sans id");
        try {
            itemRepository.Create(item);
        } catch (Exception e) {
            e.printStackTrace();
       }

    }
}
