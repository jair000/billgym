/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billgym.pe.controller;

/**
 *
 * @author jairinho
 */
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.billgym.pe.entity.Loguin;
import com.billgym.pe.entity.RolUsuario;
import com.billgym.pe.repository.LoguinRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoguinRepository loguinRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔎 Buscando usuario: " + username);

        Loguin loguin = loguinRepository.findByUsuario(username);

        if (loguin == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        RolUsuario rolEnum = loguin.getUsuarioDato().getRol();
        String rol = rolEnum.getNombreRol(); 

        Collection<? extends GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_" + rol.toUpperCase()));
        
        System.out.println("✅ Usuario encontrado: " + loguin.getUsuario() + " con rol: " + loguin.getUsuarioDato().getRol());


        return new User(loguin.getUsuario(), loguin.getPassword(), authorities);
    }
}
