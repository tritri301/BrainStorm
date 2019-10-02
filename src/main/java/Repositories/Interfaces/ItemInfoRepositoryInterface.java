package Repositories.Interfaces;

import Models.ItemInfo;

import java.util.List;

public interface ItemInfoRepositoryInterface {
    ItemInfo FindById(int id) throws Exception;
    List<ItemInfo> FindByName(String name) throws Exception;
    List<ItemInfo> FindAll() throws Exception;
    void Update(ItemInfo itemInfoToUpdate) throws Exception;
    void Delete(int id) throws Exception;
    void Create(ItemInfo itemInfoToAdd) throws Exception;
}
