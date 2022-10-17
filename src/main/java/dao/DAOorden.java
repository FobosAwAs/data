package dao;

import bd.ManagerConexion;
import dto.DTOorden;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOorden implements DAOOrdenIMP {

    ManagerConexion con = ManagerConexion.getIntance();

    @Override
    public DTOorden get(DTOorden t) {
        
        double id = ((DTOorden) t).getId_orden();
        ResultSet rs = null;
        DTOorden ram = null;

        try {
            String select = "select * from ORDERS where ORD_NUM = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(select);
            pstm.setDouble(1, id);
            rs = pstm.executeQuery();
            if (rs.isBeforeFirst() && rs.next()) {
                ram = new DTOorden();
                ram.setId_orden(rs.getDouble("ORD_NUM"));
                ram.setCantidad(rs.getDouble("ORD_AMOUNT"));
                ram.setAgente(rs.getInt("CUST_CODE"));
                ram.setCliente(rs.getInt("AGENT_CODE"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ram;
    }

    @Override
    public void insert(DTOorden t) throws SQLException {
        DTOorden k = (DTOorden) t;
        String insert = "insert into ORDERS (ORD_NUM,ORD_AMOUNT,CUST_CODE,AGENT_CODE) values (?,?,?,?)";
        PreparedStatement pstm = con.getConexion().getCon().prepareStatement(insert);

        pstm.setDouble(1, k.getId_orden());
        pstm.setDouble(2, k.getCantidad());
        pstm.setInt(3, k.getCliente());
        pstm.setInt(4, k.getAgente());
        pstm.executeUpdate();
    }

    @Override
    public void update(DTOorden t) {
        try {
            String insert = "update ORDERS set (ORD_AMOUNT,CUST_CODE,AGENT_CODE) values (?,?,?) where ORD_NUM = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(insert);

            pstm.setDouble(1, t.getId_orden());
            pstm.setDouble(2, t.getCantidad());
            pstm.setInt(3, t.getCliente());
            pstm.setInt(4, t.getAgente());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(DTOorden t) {
        try {
            String delete = "delete from ORDERS where ORD_NUM = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(delete);

            pstm.setDouble(1, t.getId_orden());
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
