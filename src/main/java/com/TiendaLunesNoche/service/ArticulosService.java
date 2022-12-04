/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.service;
import com.TiendaLunesNoche.domain.Articulo;
import java.util.List;

public interface ArticulosService {
public List<Articulo> getArticulos(boolean activos);
  
public void save(Articulo cliente);

public void delete(Articulo cliente);

public Articulo getArticulo(Articulo cliente);
}