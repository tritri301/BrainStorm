package Repositories;

import java.sql.*;

import Factory.ItemFactory;
import Models.ConnectionBD;
import Repositories.Interfaces.ItemRepositoryInterface;
import Models.Item;

public class ItemRepository implements ItemRepositoryInterface {
    private static final ItemRepository instance = new ItemRepository();
    private ConnectionBD BD = ConnectionBD.GetInstance();
    private Statement stmt = BD.GetStatement();
    private ItemFactory itemFactory = ItemFactory.GetInstance();

    @Override
    public Item FindById(int id) throws Exception{
        ResultSet rs = stmt.executeQuery("select * from item where IdItem = " + id);
        return itemFactory.Create(rs.getInt(0), rs.getInt(1), rs.getInt(2), rs.getString(3));
    }

    @Override
    public Item[] FindAll() throws Exception {
        return new Item[0];
    }

    @Override
    public void Update(int id) throws Exception {

    }

    @Override
    public void Delete(int id) throws Exception {

    }

    @Override
    public Item Create(Item itemToAdd) throws Exception {
        return null;
    }

    public static ItemRepository GetInstance() {
        return instance;
    }
}