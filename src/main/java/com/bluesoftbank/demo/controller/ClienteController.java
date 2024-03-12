package com.bluesoftbank.demo.controller;

import com.bluesoftbank.demo.dto.APIResponseDTO;
import com.bluesoftbank.demo.dto.cliente.ClientePersonaDTO;
import com.bluesoftbank.demo.model.entity.ClienteEntity;
import com.bluesoftbank.demo.service.ClienteInterface;
import com.bluesoftbank.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ClienteInterface clienteService;

    @GetMapping("cliente")
    public ResponseEntity<APIResponseDTO<Object>> findAll(){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            List<ClienteEntity> clientes = clienteService.findAll();
            if(!clientes.isEmpty()) {
                response.setResponse(clientes, "Clientes encontrado", "200");
            }else {
                response.setFail("No hay datos", "404");
            }
        }catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta de clientes", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @GetMapping("clientepersona")
    public ResponseEntity<APIResponseDTO<Object>> findClientePersona(){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            List<ClientePersonaDTO> clientes = clienteService.findClientePersona();
            if(!clientes.isEmpty()) {
                response.setResponse(clientes, "Clientes encontrado", "200");
            }else {
                response.setFail("No hay datos", "404");
            }
        }catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta de clientes", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<APIResponseDTO<Object>> showById(@PathVariable Integer id){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            ClienteEntity cliente =  clienteService.findById(id);
            if(cliente != null) {
                response.setResponse(cliente, "Cliente encontrado", "200");
            }else {
                response.setFail("Cliente no encontrado", "404");
            }
        } catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta del cliente", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<APIResponseDTO<Object>>  create(@RequestBody ClienteEntity cliente){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            ClienteEntity clienteCreado = clienteService.save(cliente);
            if(clienteCreado != null) {
                response.setResponse(cliente, "Cliente creado correctamente", "200");
            }else {
                response.setFail("El cliente no se pudo crear", "400");
            }
        }catch(DataAccessException exDt){
            response.setFailError("Error durante la insercion del cliente", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CONTINUE)
    public ResponseEntity<APIResponseDTO<Object>> update(@RequestBody ClienteEntity cliente){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            ClienteEntity clienteCreado = clienteService.save(cliente);
            if(clienteCreado != null) {
                response.setResponse(cliente, "Cliente actualizado correctamente", "200");
            }else {
                response.setFail("El cliente no se pudo actualizar", "400");
            }
        }catch(DataAccessException exDt){
            response.setFailError("Error durante la actualizacion del cliente", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<APIResponseDTO<Object>> delete(@PathVariable Integer id){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            ClienteEntity cliente = clienteService.findById(id);
            clienteService.delete(cliente);
            response.setSuccess("Eliminado correctamente", "200");
        }catch (DataAccessException exDt){
            response.setFailError("Error durante el borrado del cliente", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }
}
