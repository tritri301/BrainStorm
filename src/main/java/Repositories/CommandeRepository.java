package Repositories;

import Factory.CommandeFactory;
import Models.Commande;
import Models.ConnectionBD;
import Repositories.Interfaces.CommandeRepositoryInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Commande repository.
 */
public class CommandeRepository implements CommandeRepositoryInterface {
    private static final CommandeRepository instance = new CommandeRepository();
    private Connection con;
    private CommandeFactory commandeFactory;

    /**
     * Instantiates a new Commande repository.
     */
    public CommandeRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.commandeFactory = CommandeFactory.GetInstance();
    }

    /**
     * Get instance commande repository.
     *
     * @return the commande repository
     */
    public static CommandeRepository GetInstance() {
        return instance;
    }

    @Override
    public Commande FindById(int id) throws Exception {

        PreparedStatement stmt = con.prepareStatement("select * from commande where idCommande = ?");
        stmt.setInt(1 ,id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return commandeFactory.Create(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7));
    }

    @Override
    public Commande FindByIdItem(int id) throws Exception {
        PreparedStatement stmt = con.prepareStatement("select * from commande where idItem = ?");
        stmt.setInt(1 ,id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return commandeFactory.Create(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7));
    }

    @Override
    public List<Commande> FindAll() throws Exception {

        List<Commande> commande = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from commande");
        while(rs.next())
        {
            commande.add(commandeFactory.Create(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7)));
        }
        return commande;
    }

    @Override
    public void Update(Commande commandeToUpdate) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update commande set idCommande = ?, DateCommande = ?, DateLivraison = ?, Etat = ? , DateLivraisonPrevu = ? , nomPEnvoi = ? , nomPRecu = ? where idCommande = " + commandeToUpdate.getIdCommande());
        stmt.setInt(1, commandeToUpdate.getIdCommande());
        stmt.setDate(2, commandeToUpdate.getDateCommande());
        stmt.setDate(3, commandeToUpdate.getDateLivraison());
        stmt.setInt(4, commandeToUpdate.getEtat());
        stmt.setDate(5, commandeToUpdate.getDateLivraisonPrevu());
        stmt.setString(6, commandeToUpdate.getNomPEnvoi());
        stmt.setString(7, commandeToUpdate.getNomPEnvoi());

        stmt.execute();
    }

    @Override
    public int Create(Commande commandeToAdd) throws Exception {
        int nbRow;
        int idCreated = 0;

        PreparedStatement stmt = con.prepareStatement("insert into commande values(default, ?, ?, default,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        stmt.setDate(1, commandeToAdd.getDateCommande());
        stmt.setDate(2, commandeToAdd.getDateLivraison());
        stmt.setDate(3, commandeToAdd.getDateLivraisonPrevu());
        stmt.setString(4, commandeToAdd.getNomPEnvoi());
        stmt.setString(5, commandeToAdd.getNomPRecu());
        nbRow = stmt.executeUpdate();

        if (nbRow == 0)
        {
            throw new SQLException("no rows affected.");
        }
        else
        {
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idCreated = (int)generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return idCreated;
    }
}
