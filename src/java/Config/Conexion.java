
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HotelOmega;encrypt=false;trustServerCertificate=false","sa","Ulatina2022.");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HotelOmega;integratedSecurity=true;encrypt=false;trustServerCertificate=false;");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error"+e);
        }
    }
    
    public Connection getConection(){
        return con;
    }
}
