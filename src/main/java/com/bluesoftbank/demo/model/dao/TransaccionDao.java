package com.bluesoftbank.demo.model.dao;

import com.bluesoftbank.demo.model.entity.ClienteEntity;
import com.bluesoftbank.demo.model.entity.TransaccionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransaccionDao extends CrudRepository<TransaccionEntity, Integer> {
}