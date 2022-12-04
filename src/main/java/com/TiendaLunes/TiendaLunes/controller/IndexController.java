
package com.TiendaLunes.TiendaLunes.controller;

import com.TiendaLunes.TiendaLunes.dao.ClienteDAO;
import com.TiendaLunes.TiendaLunes.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ClienteDAO clienteDao;
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura MVC");
        
        var clientes=clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
