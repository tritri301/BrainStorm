package Controllers;

import Controllers.Interface.ItemControllerInterface;
import Models.Item;
import Services.ItemService;

import java.util.List;
import Exception.*;

public class ItemController implements ItemControllerInterface
{
    private static final ItemController instance = new ItemController();
    ItemService itemService = ItemService.GetInstance();
    //ItemService itemService = ItemService.GetInstance();

    //---------------------------------- ITEM CONTROLLER
    @Override
    public Item FindById(int id) {
        Item item =  null;
        try {
             item = itemService.FindById(id);
        } catch (ExceptionCustom exceptionCustom) {

        }
        return item;
    }


    @Override
    public int FindAmountById(int id) {
        int amountID = 0;
        try {
             amountID = itemService.FindAmountById(id);
        } catch (ExceptionCustom exceptionCustom) {
            //Alert ;
        }

        return amountID;
    }

    @Override
    public List<Item> FindAll() {
        List<Item> itemList;

        try {
            itemList = itemService.FindAll();
        } catch (ExceptionCustom exceptionCustom) {
            //Alert ;
        }

        return itemList;
    }

    @Override
    public List<Item> FindByName(String name) {
            List<Item> itemList;
        try {
              itemList = itemService.FindByName(name);
        } catch (ExceptionCustom exceptionCustom) {
            //Alert ;
        }
        return itemList;
    }

    @Override
    public boolean Update(int idItem, int idItemInfo, int idContainer, String description) {

        boolean update = true;

        try {
            update = itemService.Update(idItem,idItemInfo,idContainer,description);
        } catch (ExceptionCustom exceptionCustom) {
            //Alert ;
        }

        return update;
    }

    @Override
    public boolean Create(int idItem, int idItemInfo, int idContainer, String description) {

        boolean create = true;

        try {
            create = itemService.Create(idItem,idItemInfo,idContainer,description);
        } catch (ExceptionCustom exceptionCustom) {
            //Alert ;
        }

        return create;
    }

    @Override
    public boolean Delete(int id) {
        boolean delete = true;
        try {
            delete = itemService.Delete(id);
        } catch (ExceptionCustom exceptionCustom) {
            //Alert ;
        }

        return delete;
    }
}
//----------------------------------------------------------------------------------------------------------------------
