package Repositories.Interfaces;

import Models.Item;

public interface ItemRepositoryInterface {
    Item FindById(int id);
    Item[] FindAll();
    boolean Update(int id);
    boolean Delete(int id);
    Item Create(Item itemToAdd);
}
