package Repositories.Interfaces;

import Models.Item;

public interface ItemRepositoryInterface {
    Item FindById(int id) throws Exception;
    Item[] FindAll() throws Exception;
    boolean Update(int id) throws Exception;
    boolean Delete(int id) throws Exception;
    Item Create(Item itemToAdd) throws Exception;
}
