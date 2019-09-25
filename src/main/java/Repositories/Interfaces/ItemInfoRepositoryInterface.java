package Repositories.Interfaces;

import Models.ItemInfo;

public interface ItemInfoRepositoryInterface {
    ItemInfo FindById(int id);
    ItemInfo[] FindAll();
    boolean Update(int id);
    boolean Delete(int id);
    ItemInfo Create(ItemInfo itemInfoToAdd);
}
