package com.bluesoftbank.demo.service.impl;


import com.bluesoftbank.demo.model.dao.CuentaDao;
import com.bluesoftbank.demo.model.entity.CuentaEntity;
import com.bluesoftbank.demo.service.CuentaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuentaImpl implements CuentaInterface {

    @Autowired
    CuentaDao cuentaDao;

    @Transactional
    @Override
    public CuentaEntity save(CuentaEntity cliente) {
        return cuentaDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public CuentaEntity findById(Integer id) {
        return cuentaDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CuentaEntity> findAll() {
        return (List<CuentaEntity>) cuentaDao.findAll();
    }

    @Transactional
    @Override
    public void delete(CuentaEntity cuenta) {
        cuentaDao.delete(cuenta);
    }
}
