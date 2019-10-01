package Repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Factory.ItemFactory;
import Models.ConnectionBD;
import Repositories.Interfaces.ItemRepositoryInterface;
import Models.Item;

public class ItemRepository implements ItemRepositoryInterface {
    private static final ItemRepository instance = new ItemRepository();
    private Connection con;
    private ItemFactory itemFactory;

    public ItemRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.itemFactory = ItemFactory.GetInstance();
    }

    @Override
    public void Update(Item itemToUpdate) throws Exception {

    }

    @Override
    public Item FindByName(String name) throws Exception{
        return new Item();
    }

    @Override
    public Item FindById(int id) throws Exception{
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item where idItem = " + id);
        rs.next();
        return itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
    }

    @Override
    public List<Item> FindAll() throws Exception {
        List<Item> newItem = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item");
        while(rs.next())
        {
            newItem.add(itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
        }
        return newItem;
    }

    @Override
    public void Delete(int id) throws Exception {
        PreparedStatement stmt = con.prepareStatement("delete from item where idItem = " + id);
        stmt.execute();
    }

    @Override
    public void Create(Item itemToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into item values(?, ?, ?, ?)");
        stmt.setInt(1, itemToAdd.getIdItem());
        stmt.setInt(2, itemToAdd.getIdItemInfo());
        stmt.setInt(3, itemToAdd.getIdContainer());
        stmt.setString(4, itemToAdd.getDescription());

        stmt.execute();
    }

    public static ItemRepository GetInstance() {
        return instance;
    }
}