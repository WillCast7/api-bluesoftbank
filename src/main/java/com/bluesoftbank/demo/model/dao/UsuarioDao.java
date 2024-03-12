package com.bluesoftbank.demo.model.dao;

import com.bluesoftbank.demo.dto.cliente.ClientePersonaDTO;
import com.bluesoftbank.demo.dto.usuario.UsuarioPersonaDTO;
import com.bluesoftbank.demo.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioDao extends CrudRepository<UsuarioEntity, Integer> {
    @Query("SELECT new com.bluesoftbank.demo.dto.usuario.UsuarioPersonaDTO(" +
            "per.persona_tipodni, " +
            "per.persona_dni, " +
            "per.persona_primernombre, " +
            "per.persona_segundonombre, " +
            "per.persona_primerapellido, " +
            "per.persona_segundoapellido, " +
            "per.persona_telefono, " +
            "usr.usuario, " +
            "usr.rol_id, " +
            "per.persona_direccion, " +
            "usr.usuario_correo, " +
            "usr.fcreacion, " +
            "usr.estado )" +
            "FROM UsuarioEntity usr " +
            "INNER JOIN PersonaEntity per ON per.persona_id = usr.persona_id")
    List<UsuarioPersonaDTO> findUsuarioPersona();
}