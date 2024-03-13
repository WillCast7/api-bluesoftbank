package com.bluesoftbank.demo.controller;

import com.bluesoftbank.demo.model.dto.APIResponseDTO;
import com.bluesoftbank.demo.model.dto.usuario.UsuarioPersonaDTO;
import com.bluesoftbank.demo.model.entity.UsuarioEntity;
import com.bluesoftbank.demo.service.UsuarioInterface;
import com.bluesoftbank.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioInterface usuarioService;

    @GetMapping("usuario")
    public ResponseEntity<APIResponseDTO<Object>> findAll(){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            List<UsuarioEntity> usuarios = usuarioService.findAll();
            if(!usuarios.isEmpty()) {
                response.setResponse(usuarios, "Usuarios encontrado", "200");
            }else {
                response.setFail("No hay datos", "404");
            }
        }catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta de usuarios", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @GetMapping("usuariopersona")
    public ResponseEntity<APIResponseDTO<Object>> findUsuarioPersona(){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            List<UsuarioPersonaDTO> usuarios = usuarioService.findUsuarioPersona();
            if(!usuarios.isEmpty()) {
                response.setResponse(usuarios, "Usuarios encontrado", "200");
            }else {
                response.setFail("No hay datos", "404");
            }
        }catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta de usuarios", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<APIResponseDTO<Object>> showById(@PathVariable Integer id){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            UsuarioEntity usuario =  usuarioService.findById(id);
            if(usuario != null) {
                response.setResponse(usuario, "Usuario encontrado", "200");
            }else {
                response.setFail("Usuario no encontrado", "404");
            }
        } catch (DataAccessException exDt){
            response.setFailError("Error durante la consulta del usuario", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @PostMapping("usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<APIResponseDTO<Object>>  create(@RequestBody UsuarioEntity usuario){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            UsuarioEntity usuarioCreado = usuarioService.save(usuario);
            if(usuarioCreado != null) {
                response.setResponse(usuario, "Usuario creado correctamente", "200");
            }else {
                response.setFail("El usuario no se pudo crear", "400");
            }
        }catch(DataAccessException exDt){
            response.setFailError("Error durante la insercion del usuario", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @PutMapping("usuario")
    @ResponseStatus(HttpStatus.CONTINUE)
    public ResponseEntity<APIResponseDTO<Object>> update(@RequestBody UsuarioEntity usuario){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            UsuarioEntity clienteCreado = usuarioService.save(usuario);
            if(clienteCreado != null) {
                response.setResponse(usuario, "Usuario actualizado correctamente", "200");
            }else {
                response.setFail("El usuario no se pudo actualizar", "400");
            }
        }catch(DataAccessException exDt){
            response.setFailError("Error durante la actualizacion del usuario", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<APIResponseDTO<Object>> delete(@PathVariable Integer id){
        APIResponseDTO<Object> response = new APIResponseDTO<>();
        try {
            UsuarioEntity cliente = usuarioService.findById(id);
            usuarioService.delete(cliente);
            response.setSuccess("Eliminado correctamente", "200");
        }catch (DataAccessException exDt){
            response.setFailError("Error durante el borrado del usuario", "400", exDt.getMessage());
        }
        return new ResponseEntity<>(response, Util.findHttpStatusResponse(response));
    }
}
