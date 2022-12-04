/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche.controller;
import com.TiendaLunesNoche.domain.Articulo;
import com.TiendaLunesNoche.service.ArticulosService;
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
    private ArticulosService articuloService;
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura MVC");
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";
    }
     
}
