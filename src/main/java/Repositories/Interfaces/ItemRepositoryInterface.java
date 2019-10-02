package Repositories.Interfaces;

import Models.Item;

import java.util.List;

public interface ItemRepositoryInterface {
    Item FindById(int id) throws Exception;
    List<Item> FindByName(String name) throws Exception;
    List<Item> FindAll() throws Exception;
    int FindAmountById(int id) throws Exception;
    void Update(Item itemToUpdate) throws Exception;
    void Delete(int id) throws Exception;
    void Create(Item itemToAdd) throws Exception;
}
