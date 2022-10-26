package mgr;

import dto.DTOagente;

import java.util.List;

public interface MGRAgenteIMP {

    void save(DTOagente t);

    void delete(DTOagente t);
    public List<DTOagente> listado() ;
}
