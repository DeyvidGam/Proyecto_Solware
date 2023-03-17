package com.app.web.Seguridad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encrip {

	    public static void main(String[] args) {
	        String password = "987654";
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String hashedPassword = passwordEncoder.encode(password);
	        System.out.println(hashedPassword);
	    }
	}

