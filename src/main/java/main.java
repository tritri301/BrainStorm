import Factory.ItemFactory;
import Models.Item;
import Repositories.ItemRepository;
import Services.ItemInfoService;
import Services.ItemService;
import Exception.*;

import java.sql.*;
import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        ItemRepository itemRepository = ItemRepository.GetInstance();
        ItemService itemService = ItemService.GetInstance();
        ItemFactory Facto = ItemFactory.GetInstance();

        try {
            Item item = itemService.FindById(1);
        } catch (ExceptionCustom exceptionCustom) {
            System.out.print(exceptionCustom.getMessage());
        }
        ItemInfoService itemInfoService = ItemInfoService.GetInstance();

        try {
            System.out.println(itemRepository.FindAmountById(1));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
