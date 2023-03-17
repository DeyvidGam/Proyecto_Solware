package com.app.web.Seguridad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encrip {

	    public static void main(String[] args) {
	        String password = "32561";
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String hashedPassword = passwordEncoder.encode(password);
	        System.out.println(hashedPassword);
	    }
	}

