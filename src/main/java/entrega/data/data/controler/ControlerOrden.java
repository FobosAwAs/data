package entrega.data.data.controler;

import dto.DTOcliente;
import dto.DTOorden;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import mgr.MGRCliente;
import mgr.MGRClienteIMP;
import mgr.MGROrden;
import mgr.MGROrdenIMP;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/orden")
public class ControlerOrden {
    @PostMapping(path = "/save")
    void save(@RequestBody DTOorden orden) {
        MGROrdenIMP manager = new MGROrden();
        try {
            manager.save(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam("id") int  id) {
        DTOorden orden = new DTOorden();
        orden.setId_orden(id);
        MGROrdenIMP manager = new MGROrden();
        try {
            manager.delete(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOorden orden) {
        MGROrdenIMP manager = new MGROrden();
        try {
            manager.save(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
