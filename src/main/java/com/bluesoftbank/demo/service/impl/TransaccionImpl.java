package com.bluesoftbank.demo.service.impl;


import com.bluesoftbank.demo.model.dao.ClienteDao;
import com.bluesoftbank.demo.model.dao.TransaccionDao;
import com.bluesoftbank.demo.model.entity.ClienteEntity;
import com.bluesoftbank.demo.model.entity.TransaccionEntity;
import com.bluesoftbank.demo.service.TransaccionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaccionImpl implements TransaccionInterface {

    @Autowired
    TransaccionDao transaccionDao;

    @Transactional
    @Override
    public TransaccionEntity save(TransaccionEntity transaccion) {
        return transaccionDao.save(transaccion);
    }

    @Transactional(readOnly = true)
    @Override
    public TransaccionEntity findById(Integer id) {
        return transaccionDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransaccionEntity> findAll() {
        return (List<TransaccionEntity>) transaccionDao.findAll();
    }

    @Transactional
    @Override
    public void delete(TransaccionEntity transaccion) {
        transaccionDao.delete(transaccion);
    }
}
