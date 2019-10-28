package Repositories;

import Factory.ContainerFactory;
import Models.ConnectionBD;
import Repositories.Interfaces.ContainerRepositoryInterface;
import Models.Container;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContainerRepository implements ContainerRepositoryInterface
{
    private static final ContainerRepository instance = new ContainerRepository();
    private Connection con;
    private ContainerFactory containerFactory;

    public ContainerRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.containerFactory = ContainerFactory.GetInstance();
    }
    @Override
    public Container FindById(int id) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from container where idContainer = " + id);
        rs.next();
        return containerFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
    }

    @Override
    public List<Container> FindAll() throws Exception {
        List<Container> itemInfo = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from container");
        while(rs.next())
        {
            itemInfo.add(containerFactory.Create(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
        }
        return itemInfo;
    }

    @Override
    public void Update(Container containerToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update container set quantite = ?, position = ?, volume = ?, poidsmax = ?, idContainerParent = ? where idContainer = " + containerToAdd.getIdContainer());
        stmt.setInt(1, containerToAdd.getQuantite());
        stmt.setString(2, containerToAdd.getPosition());
        stmt.setInt(3, containerToAdd.getVolume());
        stmt.setInt(4, containerToAdd.getPoidsMax());
        stmt.setInt(5, containerToAdd.getIdContainerParent());

        stmt.execute();
    }

    @Override
    public void Delete(int id) throws Exception {
        PreparedStatement stmt = con.prepareStatement("delete from container where idContainer = " + id);
        stmt.execute();
    }

    @Override
    public void Create(Container containerToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into container values(?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, containerToAdd.getQuantite());
        stmt.setString(2, containerToAdd.getPosition());
        stmt.setInt(3, containerToAdd.getVolume());
        stmt.setInt(4, containerToAdd.getPoidsMax());
        stmt.setInt(5, containerToAdd.getIdContainerParent());

        stmt.execute();
    }

    public static ContainerRepository GetInstance() {
        return instance;
    }
}
