/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.service;
import com.TiendaLunesNoche.domain.Categoria;
import java.util.List;

public interface CategoriaService {
public List<Categoria> getCategorias(boolean activos);
  
public void save(Categoria cliente);

public void delete(Categoria cliente);

public Categoria getCategoria(Categoria cliente);
}