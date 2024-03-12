package com.bluesoftbank.demo.service;

import com.bluesoftbank.demo.model.entity.CuentaEntity;

import java.util.List;

public interface CuentaInterface {

    CuentaEntity save(CuentaEntity cuenta);

    CuentaEntity findById(Integer id);

    List<CuentaEntity> findAll();

    void delete(CuentaEntity cuenta);
}
