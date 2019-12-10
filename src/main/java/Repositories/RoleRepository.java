package Repositories;

import Factory.RoleFactory;
import Models.ConnectionBD;
import Models.Role;
import Repositories.Interfaces.RoleRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The type Role repository.
 */
public class RoleRepository implements RoleRepositoryInterface {
    private static final RoleRepository instance = new RoleRepository();
    private Connection con;
    private RoleFactory roleFactory;

    /**
     * Instantiates a new Role repository.
     */
    private RoleRepository() {
        ConnectionBD BD = ConnectionBD.GetInstance();
        this.con = BD.GetConnection();
        this.roleFactory = RoleFactory.GetInstance();
    }

    /**
     * Get instance role repository.
     *
     * @return the role repository
     */
    public static RoleRepository GetInstance() {
        return instance;
    }

    @Override
    public Role FindById(int id) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from role where idRole = " + id);
        rs.next();
        return roleFactory.Create(rs.getInt(1), rs.getString(2), rs.getString(3));
    }

    @Override
    public void Update(Role roleToUpdate) throws Exception {
        PreparedStatement stmt = con.prepareStatement("update role set " +
                "permission = ?, " +
                "roleName = ? " +
                "where idRole = ?");
        stmt.setString(1, roleToUpdate.getPermissions());
        stmt.setString(2, roleToUpdate.getRoleName());
        stmt.setInt(3, roleToUpdate.getIdRole());

        stmt.execute();
    }

    @Override
    public void Delete(int id) throws Exception {
        Statement stmt = con.createStatement();
        stmt.execute("delete from role where idRole = " + id);
    }

    @Override
    public Role Create(Role roleToAdd) throws Exception {
        PreparedStatement stmt = con.prepareStatement("insert into role values(default, ?, ?)");
        stmt.setString(1, roleToAdd.getPermissions());
        stmt.setString(2, roleToAdd.getRoleName());

        stmt.execute();
        stmt = con.prepareStatement("select LAST_INSERT_ID()");
        ResultSet rs = stmt.executeQuery();

        rs.next();
        int id = rs.getInt(1);

        return this.FindById(id);
    }
}
