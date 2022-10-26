package dao;

import bd.ManagerConexion;
import dto.DTOagente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOagente implements DAOAgenteIMP {

    ManagerConexion con = ManagerConexion.getIntance();

    @Override
    public DTOagente get(DTOagente t) {
        int id = ((DTOagente)t).getId_agente();
        ResultSet rs = null;
        DTOagente ram = null;

        try {
            String select = "select * from AGENTS where AGENT_CODE = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(select);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.isBeforeFirst() && rs.next()) {
                ram = new DTOagente();
                ram.setId_agente(rs.getInt("AGENT_CODE"));
                ram.setName_agente(rs.getString("AGENT_NAME"));
                ram.setArea_trabajo(rs.getString("WORKING_AREA"));
                ram.setTelefono(rs.getString("PHONE_NO"));
                ram.setPais(rs.getString("COUNTRY"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ram;
    }

    @Override
    public void insert(DTOagente t) throws SQLException {
        DTOagente k = (DTOagente) t;
        String insert = "insert into AGENTS (AGENT_CODE,AGENT_NAME,WORKING_AREA,PHONE_NO,COUNTRY) values (?,?,?,?,?)";
        PreparedStatement pstm = con.getConexion().getCon().prepareStatement(insert);

        pstm.setInt(1, k.getId_agente());
        pstm.setString(2, k.getName_agente());
        pstm.setString(3, k.getArea_trabajo());
        pstm.setString(4, k.getTelefono());
        pstm.setString(5, k.getPais());
        pstm.executeUpdate();

    }

    @Override
    public void update(DTOagente t) {
        try {
            String update = "update AGENTS set AGENT_NAME= ?, WORKING_AREA = ? ,PHONE_NO = ? ,COUNTRY = ? where AGENT_CODE = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(update);

            pstm.setString(1, t.getName_agente());
            pstm.setString(2, t.getArea_trabajo());
            pstm.setString(3, t.getTelefono());
            pstm.setString(4, t.getPais());
            pstm.setInt(5, t.getId_agente());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void eliminar(DTOagente t) {
        try {
            String delete = "delete from AGENTS where AGENT_CODE = ?";
            PreparedStatement pstm = con.getConexion().getCon().prepareStatement(delete);

            pstm.setInt(1, t.getId_agente());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<DTOagente> listado() {
        ManagerConexion con = ManagerConexion.getIntance();

        String SELECTBYID = "select * from AGENTS";
        List<DTOagente> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        DTOagente cl = null;
        try {
            pstm = con.getConexion().getCon().prepareStatement(SELECTBYID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cl = new DTOagente();
                cl.setId_agente(rs.getInt("AGENT_CODE"));
                cl.setName_agente(rs.getString("AGENT_NAME"));
                cl.setArea_trabajo(rs.getString("WORKING_AREA"));
                cl.setTelefono(rs.getString("PHONE_NO"));
                cl.setPais(rs.getString("COUNTRY"));

                lista.add(cl);
            }
        } catch (SQLException e) {

        }finally {
            try {
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

}
