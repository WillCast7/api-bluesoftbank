package com.bluesoftbank.demo.service.impl;


import com.bluesoftbank.demo.model.dao.UsuarioDao;
import com.bluesoftbank.demo.model.entity.UsuarioEntity;
import com.bluesoftbank.demo.service.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioInterface {

    @Autowired
    UsuarioDao usuarioDao;

    @Transactional
    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioEntity findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UsuarioEntity> findAll() {
        return (List<UsuarioEntity>) usuarioDao.findAll();
    }

    @Transactional
    @Override
    public void delete(UsuarioEntity usuario) {
        usuarioDao.delete(usuario);
    }
}
