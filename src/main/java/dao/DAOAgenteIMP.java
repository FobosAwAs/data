package dao;

import dto.DTOagente;

import java.sql.SQLException;

public interface DAOAgenteIMP {

    DTOagente get(DTOagente dtOagente);

    void insert(DTOagente dtOagente)throws SQLException;

    void update(DTOagente dtOagente);

    void eliminar(DTOagente dtOagente);
}
