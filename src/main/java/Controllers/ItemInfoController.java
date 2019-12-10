package Controllers;

import Controllers.Interface.ItemInfoControllerInterface;
import Exception.ExceptionCustom;
import Models.ItemInfo;
import Services.ItemInfoService;
import java.util.List;

/**
 * @Note les erreurs de Item info Controller son attrapé ailleur
 * @Note seule les "Find sont utilisé"
 */
public class ItemInfoController implements ItemInfoControllerInterface {

    private static final ItemInfoController instance = new ItemInfoController();
    private ItemInfoService itemInfoService = ItemInfoService.GetInstance();

    @Override
    public ItemInfo FindById(int id) {

        ItemInfo itemInfo =  null;
        try {
            itemInfo = itemInfoService.FindById(id);
        } catch (ExceptionCustom ignored) { }
        return itemInfo;
    }

    /**
     *  Pas utilisé
     */
    @Override
    public List<ItemInfo> FindAll() {
        List<ItemInfo> itemInfoList = null;
        try {
            itemInfoList = itemInfoService.FindAll();
        } catch (ExceptionCustom ignored) { }
        return itemInfoList;
    }

    /**
     *  Pas utilisé
     */
    @Override
    public List<ItemInfo> SortByName() {
        List<ItemInfo> itemInfoList = null;
        try {
            itemInfoList = itemInfoService.SortByName();
        } catch (ExceptionCustom ignored) { }
        return itemInfoList;
    }

    @Override
    public List<ItemInfo> FindByName(String name) {

        List<ItemInfo> itemInfoList = null;
        try {
            itemInfoList = itemInfoService.FindByName(name);
        } catch (ExceptionCustom ignored) { }

        return itemInfoList;
    }

    /**
     *  Pas utilisé
     */
    @Override
    public boolean Update(int idItem, String description, String nom, int poids, int volume) {

        boolean update = true;

        try {
            update = itemInfoService.Update(idItem,description,nom,poids,volume);
        } catch (ExceptionCustom ignored) { }

        return update;
    }

    /**
     *  Pas utilisé
     */
    @Override
    public boolean Create(int idItem, String description, String nom, int poids, int volume) {

        boolean create = true;

        try {
            create = itemInfoService.Create(idItem,description,nom,poids,volume);
        } catch (ExceptionCustom ignored) { }
        return create;

    }

    /**
     *  Pas utilisé
     */
    @Override
    public boolean Delete(int id) {
        boolean delete = true;
        try {
            delete = itemInfoService.Delete(id);
        } catch (ExceptionCustom ignored) { }
        return delete;
    }

    /**
     * Get instance item info controller.
     *
     * @return the item info controller
     */
    public static ItemInfoController GetInstance()
    {
        return instance;
    }

}
