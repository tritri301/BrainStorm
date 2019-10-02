package Services;

import Repositories.ItemInfoRepository;
import Services.Interfaces.ItemInfoServiceInterface;
import Models.ItemInfo;

/**
 * The type Item info service.
 */
public class ItemInfoService implements ItemInfoServiceInterface {

    private static final ItemInfoService instance = new ItemInfoService();
    private ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();

    @Override
    public ItemInfo FindById(int id) {
        return null;
    }

    @Override
    public ItemInfo FindByName(String name) {
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
