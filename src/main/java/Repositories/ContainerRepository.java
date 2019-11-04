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
    public Container FindById(String emplacement) throws Exception {
        PreparedStatement stmt = con.prepareStatement("select * from container where emplacement = ?");
        stmt.setString(1 , emplacement);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return containerFactory.Create(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
    }

    @Override
    public List<Container> FindAll() throws Exception {
        List<Container> itemInfo = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from container");
        while(rs.next())
        {
            itemInfo.add(containerFactory.Create(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
        }
        return itemInfo;
    }

    @Override
    public void Update(Container containerToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update container set volume = ?, volumeMax = ?, poids = ?, poidsmax = ?, emplacementParent = ? where emplacement = " + containerToAdd.getEmplacement());
        stmt.setString(1, containerToAdd.getEmplacement());
        stmt.setInt(2, containerToAdd.getVolume());
        stmt.setInt(3, containerToAdd.getVolumeMax());
        stmt.setInt(4, containerToAdd.getPoids());
        stmt.setInt(5, containerToAdd.getPoidsMax());
        stmt.setString(6, containerToAdd.getEmplacementParent());

        stmt.execute();
    }

    @Override
    public void Delete(String emplacement) throws Exception {
        PreparedStatement stmt = con.prepareStatement("delete from container where emplacement = " + emplacement);
        stmt.execute();
    }

    @Override
    public void Create(Container containerToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into container values(default ,?, ?, ?, ?, ?, ?)");
        stmt.setString(1, containerToAdd.getEmplacement());
        stmt.setInt(2, containerToAdd.getVolume());
        stmt.setInt(3, containerToAdd.getVolumeMax());
        stmt.setInt(4, containerToAdd.getPoids());
        stmt.setInt(5, containerToAdd.getPoidsMax());
        stmt.setString(6, containerToAdd.getEmplacementParent());

        stmt.execute();
    }

    public static ContainerRepository GetInstance() {
        return instance;
    }
}
