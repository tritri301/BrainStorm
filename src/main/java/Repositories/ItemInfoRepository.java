package Repositories;

import Repositories.Interfaces.ItemInfoRepositoryInterface;
import Models.ItemInfo;

public class ItemInfoRepository implements ItemInfoRepositoryInterface {
    @Override
    public ItemInfo FindById(int id) {
        return null;
    }

    @Override
    public ItemInfo[] FindAll() {
        return new ItemInfo[0];
    }

    @Override
    public boolean Update(int id) {
        return false;
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }

    @Override
    public ItemInfo Create(ItemInfo itemInfoToAdd) {
        return null;
    }
}
