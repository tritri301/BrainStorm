package Models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The type Connection bd.
 */
public class ConnectionBD
{
    private static final ConnectionBD instance = new ConnectionBD();
    private Exception ConnectionFailed = null;
    private Connection con;

    /**
     * Instantiates a new Connection bd.
     */
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

    /**
     * Get instance connection bd.
     *
     * @return the connection bd
     */
    public static ConnectionBD GetInstance() {
        return instance;
    }

    /**
     * Get connection status exception.
     *
     * @return the exception
     */
    public Exception GetConnectionStatus() {
        return this.ConnectionFailed;
    }

    /**
     * Get connection connection.
     *
     * @return the connection
     */
    public Connection GetConnection(){
        return this.con;
    }
}
