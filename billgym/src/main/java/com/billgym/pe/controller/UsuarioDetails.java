/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billgym.pe.controller;

/**
 *
 * @author jairinho
 */
import com.billgym.pe.entity.Loguin;
import com.billgym.pe.entity.RolUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UsuarioDetails implements UserDetails {private final Loguin loguin;

public UsuarioDetails(Loguin loguin) {
    this.loguin = loguin;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    RolUsuario rol = loguin.getUsuarioDato().getRol(); 
    return Collections.singleton(
            new SimpleGrantedAuthority("ROLE_" + rol)
    );
}

@Override
public String getPassword() {
    return loguin.getPassword();
}

@Override
public String getUsername() {
    return loguin.getUsuario();
}

@Override
public boolean isAccountNonExpired() {
    return true;
}

@Override
public boolean isAccountNonLocked() {
    return true;
}

@Override
public boolean isCredentialsNonExpired() {
    return true;
}

@Override
public boolean isEnabled() {
    return true;
}

public Loguin getLoguin() {
    return loguin;
}
}