package com.app.web.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
		http.authorizeRequests()
                .antMatchers("/Solware2/homme/index", "/Solware2/homme/inicioSesion", 
                		"/Solware2/homme/Nosotros", "/Solware2/homme/Servicios", "/Solware2/homme/Quienesmos", 
                		"/Solware2/homme/vision", "/Solware2/homme/mision", "/Solware2/homme/Recordarcontra", 
                		"/Solware2/homme/Contactenos","/js/**","/css/**","/img/**","/bootstrap/**","/manualC/**","/css/**","/manualC/Manual Corporativo SOL-WARE.pdf"
                		,"/Solware2/home/**","/Solware2/**").permitAll()
                
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/Solware2/homme/inicioSesion")
                .permitAll()
                .and()
                .logout().permitAll();
    } 
    
    
   

}