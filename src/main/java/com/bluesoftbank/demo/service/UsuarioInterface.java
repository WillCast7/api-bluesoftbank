package com.bluesoftbank.demo.service;

import com.bluesoftbank.demo.model.dto.usuario.UsuarioPersonaDTO;
import com.bluesoftbank.demo.model.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioInterface {

    UsuarioEntity save(UsuarioEntity usuario);

    UsuarioEntity findById(Integer id);

    List<UsuarioEntity> findAll();

    List<UsuarioPersonaDTO> findUsuarioPersona();
    void delete(UsuarioEntity usuario);
}
