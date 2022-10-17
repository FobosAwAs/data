package mgr;

import dto.DTOcliente;
import dto.DTOorden;

public interface MGROrdenIMP {

    void save(DTOorden t);

    void delete(DTOorden t);
}
