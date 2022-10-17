package dao;

import dto.DTOcliente;
import dto.DTOorden;

import java.sql.SQLException;

public interface DAOOrdenIMP {

    DTOorden get(DTOorden t);

    void insert(DTOorden t)throws SQLException;

    void update(DTOorden t);

    void eliminar(DTOorden t);
}
