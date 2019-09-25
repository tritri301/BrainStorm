package Repositories;

import java.sql.*;

import Factory.ItemFactory;
import Repositories.Interfaces.ItemRepositoryInterface;
import Models.Item;
import sun.security.jca.GetInstance;

public class ItemRepository implements ItemRepositoryInterface {
    private Statement stmt;
    private static final ItemRepository instance = new ItemRepository();


    public void SetConnection(Connection con) throws Exception {
        stmt = con.createStatement();
    }
    @Override
    public Item FindById(int id) throws Exception{

        ResultSet rs = stmt.executeQuery("select * from item where IdItem = " + id);
        rs.getInt("IdItem");
        return new Item();
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
    public ItemRepository GetInstance()
    {
        return instance;
    }
}