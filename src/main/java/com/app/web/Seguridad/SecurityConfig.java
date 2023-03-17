package com.app.web.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure(HttpSecurity http) method called");
        http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/Solware2/home/index", "/Solware2/home/inicioSesion",
                    "/Solware2/home/Contactenos","/js/**","/css/**","/img/**","/bootstrap/**","/manualC/**","/css/**","/manualC/Manual Corporativo SOL-WARE.pdf"
                    ).permitAll()
            .antMatchers("/Solware2/home/**").hasAnyAuthority("administrador")
            .antMatchers("/Solware2/**").hasAnyAuthority("Vendedor")
            .antMatchers("/Solware2/**").hasAnyAuthority("Operario")
            .and()
            .formLogin()
            .loginPage("/Solware2/home/inicioSesion")
            .defaultSuccessUrl("/Solware2/home/Admin", true)
            .successHandler((req, resp, auth) -> {
                if (req.isUserInRole("1")) {
                    resp.sendRedirect("/Solware2/home/admin");
                } else if (req.isUserInRole("2")) {
                    resp.sendRedirect("/Solware2/InicioP");
                } else if (req.isUserInRole("3")) {
                    resp.sendRedirect("/Solware2/aa");
                } else {
                    resp.sendRedirect("/Solware2/home/");
                }
            })
            .permitAll()
        .and()
        .logout()
            .permitAll();
    }

    
   

}