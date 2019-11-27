package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionBD
{
    private static final ConnectionBD instance = new ConnectionBD();
    private Exception ConnectionFailed = null;
    private Connection con;

    public ConnectionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.setLoginTimeout(10);
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bd_louis?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "info420");

        } catch(Exception e){
            this.ConnectionFailed = e;
        }
    }

    public Exception GetConnectionStatus() {
        return this.ConnectionFailed;
    }


    public Connection GetConnection(){
        return this.con;
    }
    public static ConnectionBD GetInstance() {
    return instance;
    }
}
