package Repositories;

import Factory.UserFactory;
import Models.ConnectionBD;
import Repositories.Interfaces.UserRepositoryInterface;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    private static final UserRepository instance = new UserRepository();

    private Connection con;
    private UserFactory userFactory;

    public UserRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.userFactory = UserFactory.GetInstance();
    }

    @Override
    public User FindById(int id) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user where idUser = " + id);
        rs.next();
        return userFactory.Create(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getInt(8));
    }

    @Override
    public List<User> FindByEmail(String email) throws Exception {
        List<User> item = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from user where email = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            item.add(userFactory.Create(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8)));
        }
        return item;
    }

    @Override
    public List<User> FindAll() throws Exception {
        List<User> item = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        rs.next();
        while(rs.next())
        {
            item.add(userFactory.Create(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8)));
        }
        return item;
    }

    @Override
    public void Update(User userToUpdate) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update user set " +
                "email = ?, " +
                "password = ?, " +
                "poste = ?, " +
                "lastName = ?, " +
                "firstName = ?, " +
                "adresse = ?, " +
                "idRole = ? " +
                "where idUser = ?");
        stmt.setInt(8, userToUpdate.getIdUser());
        stmt.setString(1, userToUpdate.getEmail());
        stmt.setString(2, userToUpdate.getPassword());
        stmt.setString(3, userToUpdate.getPoste());
        stmt.setString(4, userToUpdate.getLastName());
        stmt.setString(5, userToUpdate.getFirstName());
        stmt.setString(6, userToUpdate.getAdresse());
        stmt.setInt(7, userToUpdate.getIdRole());

        stmt.execute();
    }

    @Override
    public void Delete(int id) throws Exception {
        Statement stmt = con.createStatement();
        stmt.execute("delete from user where idUser = " + id);
    }

    @Override
    public void Create(User userToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into user values(?, ?, ?, ?, ?, ? ,? ,?)");
        stmt.setInt(1, userToAdd.getIdUser());
        stmt.setString(2, userToAdd.getEmail());
        stmt.setString(3, userToAdd.getPassword());
        stmt.setString(4, userToAdd.getPoste());
        stmt.setString(5, userToAdd.getLastName());
        stmt.setString(6, userToAdd.getFirstName());
        stmt.setString(7, userToAdd.getAdresse());
        stmt.setInt(8, userToAdd.getIdRole());

        stmt.execute();
    }

    public static UserRepository GetInstance() {
        return instance;
    }
}
