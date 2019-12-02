package Repositories;

import Factory.ItemFactory;
import Models.ConnectionBD;
import Models.Item;
import Repositories.Interfaces.ItemRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<Item> FindByName(String name) throws Exception{
        List<Item> item = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select item.* from item, itemInfo where itemInfo.idItemInfo = item.idItemInfo and nom = ?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            item.add(itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
        }
        return item;
    }

    @Override
    public Item FindById(int id) throws Exception{
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item where idItem = " + id);
        rs.next();
        return itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5));
    }

    public Item findSimilar(int idItemInfo,String emplacement,String description) throws Exception{
        PreparedStatement stmt = con.prepareStatement("select * from item where idIteminfo = ? and emplacement = ? and description = ?");
        stmt.setInt(1, idItemInfo);
        stmt.setString(2, emplacement);
        stmt.setString(3, description);
        stmt.execute();

        ResultSet rs = stmt.getResultSet();
        if(rs.next())
        {
            return itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5));
        }else{
            return null;
        }

    }

    @Override
    public Item findSimilar(int idItemInfo, String description) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from item where idIteminfo = ? and emplacement IS NULL and description = ?");
        stmt.setInt(1, idItemInfo);
        stmt.setString(2, description);
        stmt.execute();

        ResultSet rs = stmt.getResultSet();
        if(rs.next())
        {
            return itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5));
        }else{
            return null;
        }
    }

    @Override
    public List<Item> FindAll() throws Exception {
        List<Item> item = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item");
        while(rs.next())
        {
            item.add(itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
        }
        return item;
    }

    @Override
    public List<Item> SortByName() throws Exception {
        List<Item> item = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item, itemInfo where itemInfo.idItemInfo = item.idItemInfo order by nom");
        while(rs.next())
        {
            item.add(itemFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
        }
        return item;
    }
    public int FindAmountById(int id) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) from item, itemInfo where item.idItemInfo = itemInfo.idItemInfo and item.idItemInfo = " + id);
        rs.next();
        return rs.getInt(1);
    }
    @Override
    public void Delete(int id, int quantite) throws Exception {
        int quantiteFinale = this.FindById(id).getQuantite() - quantite;
        PreparedStatement stmt;
        if(quantiteFinale > 0) {
            stmt = con.prepareStatement("update item set quantite = " + quantiteFinale +" where idItem = " + id);
        }else{
            stmt = con.prepareStatement("delete from item where idItem = " + id);
        }
        stmt.execute();
    }

    @Override
    public void Create(Item itemToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into item values(default, ?, ?, ?, ?)");
        stmt.setInt(1, itemToAdd.getIdItemInfo());
        stmt.setString(2, itemToAdd.getEmplacement());
        stmt.setInt(4, itemToAdd.getQuantite());
        stmt.setString(3, itemToAdd.getDescription());
        stmt.execute();
    }

    @Override
    public void Update(Item itemToUpdate) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update item set idItemInfo = ?, emplacement = ?, description = ?, quantite = ? where idItem = " + itemToUpdate.getIdItem());
        stmt.setInt(1, itemToUpdate.getIdItemInfo());
        stmt.setString(2, itemToUpdate.getEmplacement());
        stmt.setInt(4, itemToUpdate.getQuantite());
        stmt.setString(3, itemToUpdate.getDescription());

        stmt.execute();
    }

    public static ItemRepository GetInstance() {
        return instance;
    }
}