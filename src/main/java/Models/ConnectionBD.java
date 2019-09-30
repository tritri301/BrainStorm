package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionBD
{
    private static final ConnectionBD instance = new ConnectionBD();
    private Exception ConnectionFailed = null;
    private Statement stmt;

    public ConnectionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://10.20.40.40:3306/EquipeTristan_BD", "BrainStorm", "info420");

            this.stmt = con.createStatement();
        } catch(Exception e){
            this.ConnectionFailed = e;
        }
    }

    public Exception GetConnectionStatus() {
        return this.ConnectionFailed;
    }


    public Statement GetStatement(){
        return this.stmt;
    }
    public static ConnectionBD GetInstance() {
    return instance;
    }
}
