package com.bluesoftbank.demo.service;

import com.bluesoftbank.demo.model.entity.TransaccionEntity;

import java.util.List;

public interface TransaccionInterface {

    TransaccionEntity save(TransaccionEntity transaccion);

    TransaccionEntity findById(Integer id);

    List<TransaccionEntity> findAll();

    void delete(TransaccionEntity transaccion);
}
