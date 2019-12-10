package Repositories;


import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Models.ItemInfo;
import Repositories.Interfaces.ReportRepositoryInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Report repository.
 */
//Implémentation des requêtes
public class ReportRepository implements ReportRepositoryInterface {
    private static final ReportRepository instance = new ReportRepository();
    private Connection con;
    private ReportRepository reportRepository;
    private ItemInfoFactory itemInfoFactory;

    /**
     * Instantiates a new Report repository.
     */
    private ReportRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.itemInfoFactory = ItemInfoFactory.GetInstance();
    }

    /**
     * Get istance report repository.
     *
     * @return the report repository
     */
    public static ReportRepository GetIstance() {
        return instance;
    }

    public List<ItemInfo> FindAll() throws Exception {
        List<ItemInfo> itemInfo = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from itemInfo");
        while (rs.next()) {
            itemInfo.add(itemInfoFactory.Create(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
        return itemInfo;
    }
}
