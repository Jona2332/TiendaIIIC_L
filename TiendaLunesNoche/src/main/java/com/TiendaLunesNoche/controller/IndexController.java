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
public class IndexController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura MVC");
        
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
        
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
    
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model){
        clienteService.delete(cliente);  
        return "redirect:/";
    }
}
