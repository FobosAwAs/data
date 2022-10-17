package mgr;

import bd.ManagerConexion;
import dao.DAOAgenteIMP;
import dao.DAOOrdenIMP;
import dao.DAOagente;
import dao.DAOorden;
import dto.DTOagente;
import dto.DTOorden;

import java.sql.SQLException;

public class MGROrden implements MGROrdenIMP {

    DAOOrdenIMP agentevar = new DAOorden();

    @Override
    public void save(DTOorden t) {

        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();


        DTOorden awas = agentevar.get(t);

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
    public void delete(DTOorden t) {
        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();

        DTOorden awas = agentevar.get(t);
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

}
