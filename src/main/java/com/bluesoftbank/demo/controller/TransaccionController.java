package com.bluesoftbank.demo.controller;

import com.bluesoftbank.demo.dto.APIResponseDTO;
import com.bluesoftbank.demo.model.entity.CuentaEntity;
import com.bluesoftbank.demo.model.entity.TransaccionEntity;
import com.bluesoftbank.demo.service.CuentaInterface;
import com.bluesoftbank.demo.service.TransaccionInterface;
import com.bluesoftbank.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransaccionController {
    @Autowired
    private TransaccionInterface transaccionService;

    @GetMapping("transaccion")
    public ResponseEntity<APIResponseDTO<Object>> findAll(){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            List<TransaccionEntity> transacciones = transaccionService.findAll();
            System.out.println(transacciones);
            if(!transacciones.isEmpty()) {
                response.setResponse(transacciones, "Transacciones encontradas", "200");
            }else {
                response.setFail("No hay datos", "404");
            }
        }catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta de transacciones", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @GetMapping("transaccion/{id}")
    public ResponseEntity<APIResponseDTO<Object>> showById(@PathVariable Integer id){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {

            TransaccionEntity transaccion =  transaccionService.findById(id);

            if(transaccion != null) {
                response.setResponse(transaccion, "Transaccion encontrada", "200");
            }else {
                response.setFail("Transaccion no encontrado", "404");
            }
        } catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta de la transaccion", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @PostMapping("transaccion")
    public ResponseEntity<APIResponseDTO<Object>>  create(@RequestBody TransaccionEntity transaccion){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {

            TransaccionEntity transaccionCreada = transaccionService.save(transaccion);
            if(transaccionCreada != null) {
                response.setResponse(transaccion, "transaccion creada correctamente", "200");
            }else {
                response.setFail("La transaccion no se pudo realizar", "400");
            }
        }catch(DataAccessException exDt){
            response.setFailError("Error durante la insercion de la transaccion", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @PutMapping("transaccion")
    public ResponseEntity<APIResponseDTO<Object>> update(@RequestBody TransaccionEntity transaccion){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            TransaccionEntity transaccionCreada = transaccionService.save(transaccion);
            if(transaccionCreada != null) {
                response.setResponse(transaccion, "Transaccion actualizado correctamente", "200");
            }else {
                response.setFail("La transaccion no se pudo actualizar", "400");
            }
        }catch(DataAccessException exDt){
            response.setFailError("Error durante la actualizacion de la transaccion", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @DeleteMapping("transaccion/{id}")
    public ResponseEntity<APIResponseDTO<Object>> delete(@PathVariable Integer id){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            TransaccionEntity transaccion = transaccionService.findById(id);
            transaccionService.delete(transaccion);
            response.setSuccess("Eliminado correctamente", "200");
        }catch (DataAccessException exDt){
            response.setFailError("Error durante el borrado de la transaccion", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }
}
