package Controllers;

import Controllers.Interface.ItemControllerInterface;
import Exception.ExceptionCustom;
import Models.Item;
import Services.ItemService;
import View.Browser;

import java.util.List;

/**
 * The type Item controller.
 */
public class ItemController implements ItemControllerInterface
{
    private static final ItemController instance = new ItemController();
    /**
     * The Item service.
     */
    ItemService itemService = ItemService.GetInstance();
    /**
     * The Browser.
     */
    Browser browser = Browser.GetInstance();
    //ItemService itemService = ItemService.GetInstance();

    //---------------------------------- ITEM CONTROLLER
    @Override
    public Item FindById(int id) {
        Item item =  null;
        try {
             item = itemService.FindById(id);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {

        }
        return item;
    }

    @Override
    public Item trouverSimilaire(int idItemInfo, String emplacement, String description) {
        Item item =  null;
        item = itemService.trouverSimilaire(idItemInfo, emplacement, description);
        return item;
    }


    @Override
    public int FindAmountById(int id) {
        int amountID = 0;
        try {
             amountID = itemService.FindAmountById(id);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {

        }
        return amountID;
    }

    @Override
    public List<Item> FindAll() {
        List<Item> itemList = null;

        try {
            itemList = itemService.FindAll();
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return itemList;
    }

    @Override
    public List<Item> SortByName() {
        List<Item> itemList = null;

        try {
            itemList = itemService.SortByName();
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return itemList;
    }

    @Override
    public List<Item> FindByName(String name) {
            List<Item> itemList = null;
        try {
              itemList = itemService.FindByName(name);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {

        }
        return itemList;
    }

    @Override
    public boolean Update(int idItem, int idItemInfo, String emplacement, String description,int quantite) {

        boolean update = true;

        try {
            update = itemService.Update(idItem,idItemInfo,emplacement,description,quantite);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            update = false;
        }
        catch(Exception e) {
            update = false;
        }
        return update;
    }

    @Override
    public boolean Create(int idItemInfo, String emplacement, String description,int quantite) {

        boolean create = true;

        try {
            create = itemService.Create(idItemInfo,emplacement,description,quantite);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            create = false;
        }
        catch(Exception e) {
            create = false;
        }

        return create;
    }

    @Override
    public boolean Delete(int id, int quantite) {
        boolean delete = true;
        try {
            delete = itemService.Delete(id, quantite);
        } catch (ExceptionCustom e) {
            delete = false;
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            delete = false;
        }

        return delete;
    }

    public boolean MoveItem(int id,int quantite,String emplacementNouveau)
    {
        boolean move = true;

        try {
            move = itemService.MoveItem(id,quantite,emplacementNouveau);

        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            move = false;
        }
        catch(Exception e) {
            move = false;
        }

        return move;
    }

    public boolean ModifyItem(int id, String description)
    {
        boolean modify = true;

        try {
            modify = itemService.ModifyItem(id,description);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            modify = false;
        }
        catch(Exception e) {
            modify = false;
        }

        return modify;
    }

    /**
     * Get instance item controller.
     *
     * @return the item controller
     */
    public static ItemController GetInstance()
    {
        return instance;
    }
}
//----------------------------------------------------------------------------------------------------------------------

