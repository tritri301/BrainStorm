package Repositories;

import Repositories.Interfaces.ItemRepositoryInterface;
import models.Item;

public class ItemRepository implements ItemRepositoryInterface {
    @Override
    public Item FindById(int id) {
        return null;
    }

    @Override
    public Item[] FindAll() {
        return new Item[0];
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
    public Item Create(Item itemToAdd) {
        return null;
    }
}