import Factory.ItemFactory;
import Models.Item;
import Repositories.ItemRepository;
import Services.ItemService;

import java.sql.*;

public class main
{
    public static void main(String[] args)
    {
        ItemService service = ItemService.GetInstance();
        ItemFactory Facto = ItemFactory.GetInstance();


        try {
            Item item = service.FindById(1);
            System.out.println(item.getDescription());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
