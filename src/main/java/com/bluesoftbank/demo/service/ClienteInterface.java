package com.bluesoftbank.demo.service;

import com.bluesoftbank.demo.dto.cliente.ClientePersonaDTO;
import com.bluesoftbank.demo.model.entity.ClienteEntity;

import java.util.List;

public interface ClienteInterface {

    ClienteEntity save(ClienteEntity cliente);

    ClienteEntity findById(Integer id);

    List<ClienteEntity> findAll();

    List<ClientePersonaDTO> findClientePersona();
    void delete(ClienteEntity cliente);
}
