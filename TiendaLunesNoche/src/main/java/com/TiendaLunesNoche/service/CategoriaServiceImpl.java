/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.service;

import com.TiendaLunesNoche.dao.CategoriaDAO;
import com.TiendaLunesNoche.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jonha
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDAO clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) clienteDao.findAll();
        if(activos){lista.removeIf(e -> !e.isActivo());}
        return lista;
    }
    

    @Override
    @Transactional
    public void save(Categoria cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Categoria cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria cliente) {
       return clienteDao.findById(cliente.getIdCategoria()).orElse(null);
    }

    
}
