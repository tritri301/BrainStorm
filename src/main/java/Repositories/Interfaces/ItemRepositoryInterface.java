package Repositories.Interfaces;

import Models.Item;

public interface ItemRepositoryInterface {
    Item FindById(int id) throws Exception;
    Item[] FindAll() throws Exception;
    void Update(int id) throws Exception;
    void Delete(int id) throws Exception;
    Item Create(Item itemToAdd) throws Exception;
}
