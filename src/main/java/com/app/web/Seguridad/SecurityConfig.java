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
        http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/Solware2/home/index", "/Solware2/home/inicioSesion",
                   "/js/**","/css/**","/img/**","/bootstrap/**","/manualC/**","/css/**","/manualC/Manual Corporativo SOL-WARE.pdf"
                    ).permitAll()
            .antMatchers("/Solware2/admin/**").hasAuthority("Administrador")
            .antMatchers("/Solware2/Operario/**").hasAuthority("Operario")
            .antMatchers("/Solware2/Vendedor/**").hasAuthority("Vendedor")
            .and()
            .formLogin()
            .loginPage("/Solware2/home/inicioSesion")
            .successHandler((req, resp, auth) -> {
                System.out.println("User roles: " + auth.getAuthorities());
                switch (auth.getAuthorities().iterator().next().getAuthority()) {
                    case "Administrador":
                        resp.sendRedirect("/Solware2/Admin/Admin");
                        break;
                    case "Vendedor":
                        resp.sendRedirect("/Solware2/Vendedor/aa");
                        break;
                    case "Operario":
                        resp.sendRedirect("/Solware2/Operario/InicioP");
                        break;
                    default:
                        resp.sendRedirect("/Solware2/home/inicioSesion");
                        System.out.println("User does not have a valid role!");
                        break;
                }
            })

            .permitAll()
        .and()
        .logout()
            .permitAll();
    }

}
