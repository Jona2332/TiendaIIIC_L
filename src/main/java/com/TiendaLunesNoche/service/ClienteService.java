/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.service;
import com.TiendaLunesNoche.domain.Cliente;
import java.util.List;

public interface ClienteService {
public List<Cliente> getClientes();
  
public void save(Cliente cliente);

public void delete(Cliente cliente);

public Cliente getCliente(Cliente cliente);
}