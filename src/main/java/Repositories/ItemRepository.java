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
        itemFactory.Create(rs.getInt("IdItem"), );
    }

    @Override
    public Item[] FindAll() {
        return new Item[0];
    }
    public Item FindByName() {

    }
    public Item[] FindByKeyword(){

    }
    @Override
    public void Update(Item newItem) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Item Create(Item itemToAdd) {
        return null;
    }
    public static ItemRepository GetInstance() {
        return instance;
    }
}