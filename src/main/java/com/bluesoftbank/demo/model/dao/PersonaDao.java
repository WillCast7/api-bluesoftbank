package com.bluesoftbank.demo.model.dao;

import com.bluesoftbank.demo.model.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<ClienteEntity, Integer> {
}