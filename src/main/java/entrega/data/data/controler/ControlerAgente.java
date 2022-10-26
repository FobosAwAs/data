package entrega.data.data.controler;

import dto.DTOagente;
import dto.DTOrespuesta;
import mgr.MGRAgente;
import mgr.MGRAgenteIMP;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/agente")
public class ControlerAgente {

    @PostMapping(path = "/save")
    public @ResponseBody
    void save(@RequestBody DTOagente agente) {
        MGRAgenteIMP manager = new MGRAgente();
        try {
            manager.save(agente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam int  id){
    DTOagente dtOagente = new DTOagente();
    dtOagente.setId_agente(id);
        MGRAgenteIMP manager = new MGRAgente();
        try {
            manager.delete(dtOagente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOagente agente) {
        MGRAgenteIMP manager = new MGRAgente();
        try {
            manager.save(agente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/lista")
    public DTOrespuesta lista(){
        MGRAgenteIMP manager = new MGRAgente();
        DTOrespuesta respuesta = new DTOrespuesta();
        try {
            List<DTOagente> lista = manager.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (Exception e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}