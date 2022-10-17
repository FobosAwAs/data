package entrega.data.data.controler;

import dto.DTOagente;
import mgr.MGRAgente;
import mgr.MGRAgenteIMP;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
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
    void delete(@RequestParam("id") int  id){
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
}