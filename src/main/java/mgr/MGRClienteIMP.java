package mgr;

import dto.DTOagente;
import dto.DTOcliente;

public interface MGRClienteIMP {

    void save(DTOcliente t);

    void delete(DTOcliente t);
}
