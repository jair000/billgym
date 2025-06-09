package com.billgym.pe.controller;
import com.billgym.pe.controller.UsuarioDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {@Bean
public UserDetailsService userDetailsService() {
    return new UsuarioDetailsServiceImpl();
}

@Bean
public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
}

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
        throws Exception {
    return config.getAuthenticationManager();
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/css/**", "/js/**", "/img/**", "/login").permitAll()
            .requestMatchers("/usuarios").hasRole("GERENTE_GENERAL")
            .requestMatchers("/clientes").hasAnyRole("GERENTE_GENERAL", "RECEPCIONISTA", "SUPERVISOR")
            .requestMatchers("/productos").hasAnyRole("GERENTE_GENERAL", "SUPERVISOR", "ENTRENADOR")
            .requestMatchers("/maquinas").hasAnyRole("GERENTE_GENERAL", "SUPERVISOR", "ENTRENADOR")
            .requestMatchers("/delta").hasAnyRole("GERENTE_GENERAL", "ENTRENADOR")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/home", true)
        )
        .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())
        .csrf(csrf -> csrf.disable());
    return http.build();
}
}