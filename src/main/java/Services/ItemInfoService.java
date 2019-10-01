package Services;

import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Repositories.ItemInfoRepository;
import Services.Interfaces.ItemInfoServiceInterface;
import Models.ItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Item info service.
 */
public class ItemInfoService implements ItemInfoServiceInterface {

    private static final ItemInfoService instance = new ItemInfoService();
    private ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();
    private ItemInfoFactory itemFactory = ItemInfoFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();

    @Override
    public ItemInfo FindById(int id) {
        ItemInfo itemInfo = null;
        if (connectionBD == null)
        {
            try {
                itemInfo = this.itemInfoRepository.FindById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return itemInfo;
    }

    @Override
    public List<ItemInfo> FindAll() {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connectionBD == null)
        {
            try {
               // itemInfo = this.itemInfoRepository.FindAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return new ArrayList<>();
    }

    @Override
    public List<ItemInfo> FindByName(String name) {
        return null;
    }

    @Override
    public ItemInfo Update(int id) {
        return null;
    }

    @Override
    public ItemInfo Create() {
        return null;
    }

    @Override
    public ItemInfo Delete(int id) {
        return null;
    }

    public static ItemInfoService GetInstance()
    {
        return instance;
    }
}
