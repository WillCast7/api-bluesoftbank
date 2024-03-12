package com.bluesoftbank.demo.service.impl;


import com.bluesoftbank.demo.dto.cliente.ClientePersonaDTO;
import com.bluesoftbank.demo.model.dao.ClienteDao;
import com.bluesoftbank.demo.model.entity.ClienteEntity;
import com.bluesoftbank.demo.service.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteImpl implements ClienteInterface {

    @Autowired
    ClienteDao clienteDao;

    @Transactional
    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteEntity findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    public List<ClientePersonaDTO> findClientePersona(){
        return (List<ClientePersonaDTO>) clienteDao.findClientePersona();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClienteEntity> findAll() {
        return (List<ClienteEntity>) clienteDao.findAll();
    }

    @Transactional
    @Override
    public void delete(ClienteEntity cliente) {
        clienteDao.delete(cliente);
    }
}
