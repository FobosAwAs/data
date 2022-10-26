package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

    private Connection con;
    

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas", "root", "toor");
            con.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getCon() {
        return this.con;
    }

}
