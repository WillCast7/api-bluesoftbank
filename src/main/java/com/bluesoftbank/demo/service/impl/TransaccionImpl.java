package com.bluesoftbank.demo.service.impl;


import com.bluesoftbank.demo.model.dao.CuentaDao;
import com.bluesoftbank.demo.model.dao.TransaccionDao;
import com.bluesoftbank.demo.model.entity.CuentaEntity;
import com.bluesoftbank.demo.model.entity.TransaccionEntity;
import com.bluesoftbank.demo.service.CuentaInterface;
import com.bluesoftbank.demo.service.TransaccionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaccionImpl implements TransaccionInterface {

    @Autowired
    TransaccionDao transaccionDao;
    @Autowired
    CuentaDao cuentaDao;

    @Transactional
    @Override
    public TransaccionEntity save(TransaccionEntity transaccion) {

        if(transaccion.getTransaccion_tipo().equals("Egreso") &&
                transaccion.getTransaccion_tipo().equals("Ingreso")){
            System.out.println("el tipo de transaccion debe ser Engreso o Egreso");
        }

        //consulta de la cuenta para validar saldo
        CuentaEntity cuenta = cuentaDao.findById(transaccion.getCuenta_id()).orElse(null);

        //si no existe
        if(cuenta == null){
            return null;
        }

        //si el monto es menor a 0
        if( cuenta.getCuenta_saldo() - transaccion.getTransaccion_monto() < 0 &&
            transaccion.getTransaccion_tipo().equals("Egreso")){
            return null;
        }

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
