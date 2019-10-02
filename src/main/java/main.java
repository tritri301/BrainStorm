import Factory.ItemFactory;
import Models.Item;
import Repositories.ItemRepository;
import Services.ItemService;

import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        ItemService itemService = ItemService.GetInstance();
        ItemFactory Facto = ItemFactory.GetInstance();


        try {
            List<Item> itemList = itemService.FindAll();
            for(int i = 0; i < itemList.size(); i++) {
                System.out.println(itemList.get(i).getDescription());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
