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
        ResultSet rs = stmt.executeQuery("select * from itemInfo where idItemInfo = " + id);
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

    public List<ItemInfo> SortByName() throws Exception {
        List<ItemInfo> itemInfo = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from itemInfo order by nom");
        while(rs.next())
        {
            itemInfo.add(itemInfoFactory.Create(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
        return itemInfo;
    }

    @Override
    public void Update(ItemInfo itemInfoToUpdate) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update itemInfo set description = ?, nom = ?, poids = ?, volume = ? where idItemInfo = " + itemInfoToUpdate.getIdItemInfo());
        stmt.setString(1, itemInfoToUpdate.getDescription());
        stmt.setString(2, itemInfoToUpdate.getNom());
        stmt.setInt(3, itemInfoToUpdate.getPoids());
        stmt.setInt(4, itemInfoToUpdate.getVolume());

        stmt.execute();
    }

    @Override
    public void Delete(int id) throws Exception {
        PreparedStatement stmt = con.prepareStatement("delete from itemInfo where idItem = " + id);
        stmt.execute();
    }

    @Override
    public void Create(ItemInfo itemInfoToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into itemInfo values(?, ?, ?, ?, ?)");
        stmt.setInt(1, itemInfoToAdd.getIdItemInfo());
        stmt.setString(2, itemInfoToAdd.getDescription());
        stmt.setString(3, itemInfoToAdd.getNom());
        stmt.setInt(4, itemInfoToAdd.getPoids());
        stmt.setInt(5, itemInfoToAdd.getVolume());
    }
    public static ItemInfoRepository GetInstance() {
        return instance;
    }
}
