//package com.app.web.Seguridad;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//                .antMatchers("/Solware2/home/index", "/Solware2/home/inicioSesion", 
//                		"/Solware2/home/Nosotros", "/Solware2/home/Servicios", "/Solware2/home/Quienesmos", 
//                		"/Solware2/home/vision", "/Solware2/home/mision", "/Solware2/home/Recordarcontra", 
//                		"/Solware2/home/Contactenos","/js/**","/css/**","/img/**","/bootstrap/**","/manualC/**","/css/**","/manualC/Manual Corporativo SOL-WARE.pdf"
//                		,"/Solware2/home/**","/Solware2/**").permitAll()
//                
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/Solware2/home/inicioSesion")
//                .permitAll()
//                .and()
//                .logout().permitAll();
//    } 
//    
//    
//   
//
//}