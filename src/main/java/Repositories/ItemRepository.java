package Repositories;

import java.sql.*;

import Models.ConnectionBD;
import Repositories.Interfaces.ItemRepositoryInterface;
import Models.Item;

public class ItemRepository implements ItemRepositoryInterface {
    private static final ItemRepository instance = new ItemRepository();
    private ConnectionBD BD = ConnectionBD.GetInstance();
    private Statement stmt = BD.GetStatement();

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
    public static ItemRepository GetInstance() {
        return instance;
    }
}