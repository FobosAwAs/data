package mgr;

import bd.ManagerConexion;
import dao.DAOAgenteIMP;
import dao.DAOClienteIMP;
import dao.DAOagente;
import dao.DAOcliente;
import dto.DTOagente;
import dto.DTOcliente;

import java.sql.SQLException;

public class MGRCliente implements MGRClienteIMP {

    DAOClienteIMP agentevar = new DAOcliente();

    @Override
    public void save(DTOcliente t) {

        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();


        DTOcliente awas = agentevar.get(t);

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
    public void delete(DTOcliente t) {
        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();

        DTOcliente awas = agentevar.get(t);
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
