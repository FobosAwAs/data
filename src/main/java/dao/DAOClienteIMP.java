package dao;

import dto.DTOcliente;

import java.sql.SQLException;

public interface DAOClienteIMP {

    DTOcliente get(DTOcliente t);

    void insert(DTOcliente t)throws SQLException;

    void update(DTOcliente t);

    void eliminar(DTOcliente t);
}
