package Repositories.Interfaces;

import Models.Item;

public interface ItemRepositoryInterface {
    Item FindById(int id) throws Exception;
    Item[] FindAll() throws Exception;
    void Update(Item itemToUpdate) throws Exception;
    void Delete(int id) throws Exception;
    void Create(Item itemToAdd) throws Exception;
}
