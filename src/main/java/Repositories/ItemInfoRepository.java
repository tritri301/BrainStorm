package Repositories;

import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Repositories.Interfaces.ItemInfoRepositoryInterface;
import Models.ItemInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemInfoRepository implements ItemInfoRepositoryInterface {
    private static final ItemInfoRepository instance = new ItemInfoRepository();
    private Connection con;
    private ItemInfoFactory itemInfoFactory;

    public ItemInfoRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.itemInfoFactory = ItemInfoFactory.GetInstance();
    }
    @Override
    public ItemInfo FindById(int id) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item where idItem = " + id);
        rs.next();
        return itemInfoFactory.Create(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
    }

    @Override
    public List<ItemInfo> FindByName(String name) throws Exception {
        List<ItemInfo> itemInfo = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from itemInfo where name = ?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            itemInfo.add(itemInfoFactory.Create(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
        return itemInfo;
    }

    @Override
    public List<ItemInfo> FindAll() throws Exception {
        List<ItemInfo> itemInfo = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from itemInfo");
        while(rs.next())
        {
            itemInfo.add(itemInfoFactory.Create(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
        return itemInfo;
    }

    @Override
    public void Update(ItemInfo itemInfoToUpdate) throws Exception {

    }

    @Override
    public void Delete(int id) throws Exception {

    }

    @Override
    public void Create(ItemInfo itemInfoToAdd) throws Exception {

    }
    public static ItemInfoRepository GetInstance() {
        return instance;
    }
}
