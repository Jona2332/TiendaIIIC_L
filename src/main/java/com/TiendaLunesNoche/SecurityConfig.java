/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaLunesNoche;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


/**
 *
 * @author jonha
 */
@Configuration
@EnableWebSecurity
      public class SecurityConfig {
// método para hacer autenticación de usuario    
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN", "VENDEDOR", "USER")
                .and()
                .withUser("vendedor")
                    .password("{noop}123")
                    .roles("VENDEDOR", "USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER");
    }
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo", "/articulo/guardar",
                        "/articulo/modificar/**", "/articulo/eliminar/**",
                        "/categoria/nuevo", "/categoria/guardar",
                        "/categoria/modificar/**", "/categoria/eliminar/**",
                        "/cliente/nuevo", "/cliente/guardar",
                        "/cliente/modificar/**", "/cliente/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/articulo/listado", "/cliente/listado",
                        "/categoria/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")
                .antMatchers("/","/carrito/*")
                .permitAll()
                .antMatchers("/facturar/carrito")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}