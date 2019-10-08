package Controllers;

import Controllers.Interface.ItemControllerInterface;
import Controllers.Interface.ItemInfoControllerInterface;
import Models.Item;
import Models.ItemInfo;
import Services.ItemInfoService;
import Services.ItemService;

import java.util.List;
import Exception.*;


public class ItemInfoController implements ItemInfoControllerInterface {

    private static final ItemInfoController instance = new ItemInfoController();
    ItemInfoService itemInfoService = ItemInfoService.GetInstance();


    @Override
    public ItemInfo FindById(int id) {

        ItemInfo itemInfo =  null;
        try {
            itemInfo = itemInfoService.FindById(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return itemInfo;
    }

    @Override
    public List<ItemInfo> FindAll() {
        List<ItemInfo> itemInfoList = null;
        try {
            itemInfoList = itemInfoService.FindAll();
        } catch (ExceptionCustom e) {
            //Alert ;
        }
        catch(Exception e) {

        }
        return itemInfoList;
    }

    @Override
    public List<ItemInfo> FindByName(String name) {

        List<ItemInfo> itemInfoList = null;
        try {
            itemInfoList = itemInfoService.FindByName(name);
        } catch (ExceptionCustom e) {
            //Alert ;
        }
        catch(Exception e) {

        }

        return itemInfoList;

    }

    @Override
    public boolean Update(int idItem, String description, String nom, int poids, int volume) {

        boolean update = true;

        try {
            update = itemInfoService.Update(idItem,description,nom,poids,volume);
        } catch (ExceptionCustom e) {
            //Alert ;
        }
        catch(Exception e) {

        }

        return update;
    }

    @Override
    public boolean Create(int idItem, String description, String nom, int poids, int volume) {

        boolean create = true;

        try {
            create = itemInfoService.Create(idItem,description,nom,poids,volume);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return create;

    }

    @Override
    public boolean Delete(int id) {
        boolean delete = true;
        try {
            delete = itemInfoService.Delete(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return delete;
    }

    public static ItemInfoController GetInstance()
    {
        return instance;
    }

}
