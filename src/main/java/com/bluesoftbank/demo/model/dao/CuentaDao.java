package com.bluesoftbank.demo.model.dao;

import com.bluesoftbank.demo.model.entity.CuentaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CuentaDao extends CrudRepository<CuentaEntity, Integer> {
}