/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.service;

import com.TiendaLunesNoche.dao.ArticuloDAO;
import com.TiendaLunesNoche.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jonha
 */
@Service
public class ArticulosServiceImpl implements ArticulosService{

    @Autowired
    private ArticuloDAO clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) clienteDao.findAll();
        if(activos){lista.removeIf(e -> !e.isActivo());}
        return lista;
    }
    

    @Override
    @Transactional
    public void save(Articulo cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Articulo cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo cliente) {
       return clienteDao.findById(cliente.getIdArticulo()).orElse(null);
    }

    
}
