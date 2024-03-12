package com.bluesoftbank.demo.model.dao;

import com.bluesoftbank.demo.dto.cliente.ClientePersonaDTO;
import com.bluesoftbank.demo.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteDao extends CrudRepository<ClienteEntity, Integer> {
    @Query("SELECT new com.bluesoftbank.demo.dto.cliente.ClientePersonaDTO(" +
            "per.persona_tipodni, " +
            "per.persona_dni, " +
            "per.persona_primernombre, " +
            "per.persona_segundonombre, " +
            "per.persona_primerapellido, " +
            "per.persona_segundoapellido, " +
            "per.persona_telefono, " +
            "per.persona_direccion, " +
            "cl.cliente_correo, " +
            "cl.fcreacion, " +
            "cl.estado )" +
            "FROM ClienteEntity cl " +
            "INNER JOIN PersonaEntity per ON per.persona_id = cl.persona_id")
    List<ClientePersonaDTO> findClientePersona();
}
