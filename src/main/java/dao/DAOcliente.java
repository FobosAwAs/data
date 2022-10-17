package dao;

import bd.ManagerConexion;
import dto.DTOcliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOcliente implements DAOClienteIMP {

    ManagerConexion con = ManagerConexion.getIntance();

    @Override
    public DTOcliente get(DTOcliente t) {
        int id = ((DTOcliente)t).getCode_cliente();
        ResultSet rs = null;
        DTOcliente ram = null;

        try {
            String select = "select * from CUSTOMER where CUST_CODE = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(select);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.isBeforeFirst() && rs.next()) {

                ram = new DTOcliente();
                ram.setCode_cliente(rs.getInt("CUST_CODE"));
                ram.setName_cliente(rs.getString("CUST_NAME"));
                ram.setCiudad(rs.getString("CUST_CITY"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ram;
    }

    @Override
    public void insert(DTOcliente t) throws SQLException {
        DTOcliente k = (DTOcliente) t;
        String insert = "insert into CUSTOMER (CUST_CODE,CUST_NAME,CUST_CITY) values (?,?,?)";
        PreparedStatement pstm = con.getConexion().getCon().prepareStatement(insert);

        pstm.setInt(1, k.getCode_cliente());
        pstm.setString(2, k.getName_cliente());
        pstm.setString(3, k.getCiudad());

        pstm.executeUpdate();
    }

    @Override
    public void update(DTOcliente t) {
        try {
            String insert = "update CUSTOMER set CUST_NAME = ?, CUST_CITY = ? where CUST_CODE = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(insert);

            pstm.setString(1, t.getName_cliente());
            pstm.setString(2, t.getCiudad());
            pstm.setInt(3, t.getCode_cliente());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(DTOcliente t) {

        try {
            String delete = "delete from CUSTOMER where CUST_CODE = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(delete);

            pstm.setInt(1, t.getCode_cliente());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
