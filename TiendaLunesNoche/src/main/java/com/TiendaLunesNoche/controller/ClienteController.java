/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.controller;
import com.TiendaLunesNoche.domain.Cliente;
import com.TiendaLunesNoche.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/cliente/listado")
    public String inicio(Model model){
        
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modificar";
        
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
    
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model){
        clienteService.delete(cliente);  
        return "redirect:/cliente/eliminar";
    }
}
