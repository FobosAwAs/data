package bd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerConexion {

    private static ManagerConexion instance;
    private Conexion conexion;

    private ManagerConexion() {
        conexion = new Conexion();
    }

    public static ManagerConexion getIntance() {
        if (instance == null) {
            instance = new ManagerConexion();
        }
        return instance;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void close() {
        try {
            conexion.getCon().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void commit() {
        try {
            conexion.getCon().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void rollback() {
        try {
            conexion.getCon().rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reconectar(){
        conexion = new Conexion();
    }
}
