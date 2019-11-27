package Repositories;


import Controllers.ItemController;
import Controllers.ItemInfoController;
import Factory.ItemInfoFactory;
import Models.Item;
import Models.ItemInfo;
import Repositories.Interfaces.ReportRepositoryInterface;
import Models.ConnectionBD;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//Implémentation des requêtes
public class ReportRepository implements ReportRepositoryInterface {
    private static final ReportRepository instance = new ReportRepository();
    private Connection con;
    private ReportRepository reportRepository;
    private ItemInfoFactory itemInfoFactory;

    public ReportRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.itemInfoFactory = ItemInfoFactory.GetInstance();
    }

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

    public static  ReportRepository GetIstance() {return instance;}
}
