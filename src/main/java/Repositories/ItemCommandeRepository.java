package Repositories;

import Factory.ItemCommandeFactory;
import Models.ConnectionBD;
import Models.ItemCommande;
import Repositories.Interfaces.ItemCommandeRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Item commande repository.
 */
public class ItemCommandeRepository implements ItemCommandeRepositoryInterface {

    private static final ItemCommandeRepository instance = new ItemCommandeRepository();
    private Connection con;
    private ItemCommandeFactory itemCommandeFactory;

    /**
     * Instantiates a new Item commande repository.
     */
    public ItemCommandeRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.itemCommandeFactory = ItemCommandeFactory.GetInstance();
    }

    /**
     * Get instance item commande repository.
     *
     * @return the item commande repository
     */
    public static ItemCommandeRepository GetInstance() {
        return instance;
    }

    @Override
    public ItemCommande FindById(int id) throws Exception {
        PreparedStatement stmt = con.prepareStatement("select * from ItemCommande where idItemCommande = ?");
        stmt.setInt(1 ,id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return itemCommandeFactory.Create(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
    }

    @Override
    public List<ItemCommande> FindByIdCommande(int idCommande) throws Exception {
        List<ItemCommande> itemCommande = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from ItemCommande where idCommande = ?");
        stmt.setInt(1 ,idCommande);
        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            itemCommande.add(itemCommandeFactory.Create(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
        }
        return itemCommande;
    }

    @Override
    public List<ItemCommande> FindAll() throws Exception {
        List<ItemCommande> itemCommande = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from ItemCommande");
        while(rs.next())
        {
            itemCommande.add(itemCommandeFactory.Create(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
        }
        return itemCommande;
    }

    @Override
    public void Update(ItemCommande ItemCommandeToUpdate) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update ItemCommande set idItemCommande = ?, idCommande = ?, idItemInfo = ?, description = ?, quantite = ?");
        stmt.setInt(1, ItemCommandeToUpdate.getIdItemCommande());
        stmt.setInt(2, ItemCommandeToUpdate.getIdCommande());
        stmt.setInt(3, ItemCommandeToUpdate.getIdItemInfo());
        stmt.setString(4, ItemCommandeToUpdate.getDescription());
        stmt.setInt(5, ItemCommandeToUpdate.getQuantite());

        stmt.execute();
    }

    @Override
    public void Create(ItemCommande ItemCommandeToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into ItemCommande values(default, ?, ?, ?, ?)");
        stmt.setInt(1, ItemCommandeToAdd.getIdCommande());
        stmt.setInt(2, ItemCommandeToAdd.getIdItemInfo());
        stmt.setString(3, ItemCommandeToAdd.getDescription());
        stmt.setInt(4, ItemCommandeToAdd.getQuantite());

        stmt.execute();
    }
}
