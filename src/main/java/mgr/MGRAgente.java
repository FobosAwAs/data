package mgr;

import bd.ManagerConexion;
import dao.*;
import dto.DTOagente;
import dto.DTOcliente;
import dto.DTOorden;

import java.sql.SQLException;
import java.util.List;

public class MGRAgente implements MGRAgenteIMP {

    DAOAgenteIMP agentevar = new DAOagente();

    @Override
    public void save(DTOagente t) {

        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();


        DTOagente awas = agentevar.get(t);

        if (awas == null) {
            try {
                agentevar.insert(t);
                managerConexion.commit();
            } catch (SQLException ex) {
                managerConexion.rollback();
            }
        } else {
            agentevar.update(t);
            managerConexion.commit();
        }
        managerConexion.close();
    }

    @Override
    public void delete(DTOagente t) {
        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();

        DTOagente awas = agentevar.get(t);
        try {
            if (awas == null) {
                System.out.println("el agente no existe");
            } else {
                agentevar.eliminar(t);
                managerConexion.commit();
            }
        } catch (Exception e) {
            managerConexion.rollback();
        }
        managerConexion.close();

    }

    @Override
    public List<DTOagente> listado() {
        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();
        try {
            return agentevar.listado();
        } catch (Exception e) {
            managerConexion.rollback();
        } finally {
            managerConexion.close();
        }
        return null;
    }
}