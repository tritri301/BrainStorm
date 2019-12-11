package Repositories;

import Factory.UserFactory;
import Models.ConnectionBD;
import Models.User;
import Repositories.Interfaces.UserRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User repository.
 */
public class UserRepository implements UserRepositoryInterface {
    private static final UserRepository instance = new UserRepository();

    private Connection con;
    private UserFactory userFactory;

    /**
     * Instantiates a new User repository.
     */
    private UserRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.userFactory = UserFactory.GetInstance();
    }

    /**
     * Get instance user repository.
     *
     * @return the user repository
     */
    public static UserRepository GetInstance() {
        return instance;
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
                rs.getString(8),
                rs.getString(9),
                rs.getInt(10),
                rs.getInt(11));
    }

    @Override
    public List<User> FindByEmail(String email) throws Exception {
        List<User> item = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from user where email = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            item.add(userFactory.Create(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getInt(11)));
        }
        return item;
    }

    @Override
    public List<User> FindAll() throws Exception {
        List<User> item = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        rs.next();
        while (rs.next()) {
            item.add(userFactory.Create(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getInt(11)));
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
                "lastConnected = ?, " +
                "lastPassChange = ?, " +
                "UnsuccessfullConnection = ?, " +
                "idRole = ? " +
                "where idUser = ?");

        stmt.setString(1, userToUpdate.getEmail());
        stmt.setString(2, userToUpdate.getPassword());
        stmt.setString(3, userToUpdate.getPoste());
        stmt.setString(4, userToUpdate.getLastName());
        stmt.setString(5, userToUpdate.getFirstName());
        stmt.setString(6, userToUpdate.getAdresse());
        stmt.setString(7, userToUpdate.getLastConnected());
        stmt.setString(8, userToUpdate.getLastPassChange());
        stmt.setInt(9, userToUpdate.getUnsuccessfullConnection());
        stmt.setInt(10, userToUpdate.getIdRole());
        stmt.setInt(11, userToUpdate.getIdUser());

        stmt.execute();
    }

    @Override
    public void Delete(int id) throws Exception {
        Statement stmt = con.createStatement();
        stmt.execute("delete from user where idUser = " + id);
    }

    @Override
    public void Create(User userToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into user values(?, ?, ?, ?, ?, ? ,? ,?, ?, ?, ?)");
        stmt.setString(2, userToAdd.getEmail());
        stmt.setString(3, userToAdd.getPassword());
        stmt.setString(4, userToAdd.getPoste());
        stmt.setString(5, userToAdd.getLastName());
        stmt.setString(6, userToAdd.getFirstName());
        stmt.setString(7, userToAdd.getAdresse());
        stmt.setString(8, userToAdd.getLastConnected());
        stmt.setString(9, userToAdd.getLastPassChange());
        stmt.setInt(10, userToAdd.getUnsuccessfullConnection());
        stmt.setInt(11, userToAdd.getIdRole());
        stmt.setInt(1, userToAdd.getIdUser());

        stmt.execute();
    }
}
