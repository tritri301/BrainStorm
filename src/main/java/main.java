import java.sql.*;


public class main
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://10.20.40.40:3306/EquipeTristan_BD","BrainStorm","info420");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from ItemInfo");
            while(rs.next())
                System.out.println(rs.getString("Description"));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
