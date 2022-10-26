package entrega.data.data.controler;

import dto.DTOcliente;
import mgr.MGRCliente;
import mgr.MGRClienteIMP;
import org.springframework.web.bind.annotation.*;
import mgr.MGRAgente;
import mgr.MGRAgenteIMP;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "/cliente")
public class ControlerCliente {
    @PostMapping(path = "/save")
    void save(@RequestBody DTOcliente cliente) {
        MGRClienteIMP manager = new MGRCliente();
        try {
            manager.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam("id") int  id) {
        DTOcliente cliente = new DTOcliente();
        cliente.setCode_cliente(id);
        MGRClienteIMP manager = new MGRCliente();
        try {
            manager.delete(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOcliente cliente) {
        MGRClienteIMP manager = new MGRCliente();
        try {
            manager.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
