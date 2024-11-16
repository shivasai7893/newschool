package com.management.school.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcriptPassword {
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String rawPassword = "test"; // raw password
    String hashedPassword = encoder.encode(rawPassword);
   // System.out.println("Hashed Password: " + hashedPassword);

}
