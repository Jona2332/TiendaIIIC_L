/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.dao;
import com.TiendaLunesNoche.domain.Credito;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jonha
 */
public interface CreditoDAO extends CrudRepository<Credito, Long>{
    
}

