package com.bluesoftbank.demo.service;

import com.bluesoftbank.demo.model.entity.PersonaEntity;

import java.util.List;

public interface PersonaInterface {

    PersonaEntity save(PersonaEntity persona);

    PersonaEntity findById(Integer id);

    List<PersonaEntity> findAll();

    void delete(PersonaEntity persona);
}
