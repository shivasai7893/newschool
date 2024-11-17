package com.management.school.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestBody;

import com.management.school.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
	
	 protected void configure(HttpSecurity http) throws Exception {
	        // Disable CSRF protection (for stateless applications, e.g., APIs)
	        http.csrf().disable()
	            .authorizeRequests()
	                .requestMatchers("/secured/**").authenticated()  // Require authentication for /secured/**
	                .anyRequest().permitAll()  // Allow access to other URLs without authentication
	            .and()
	                .httpBasic();  
	 }
	
	
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		provider.setUserDetailsService(userDetailsService);
		
		return provider;
	}
//  @Bean
//  public UserDetailsService userDetailsService()
//  {
//	  UserDetails user1=User
//			  .withDefaultPasswordEncoder()
//			  .username("shiva").password("shiva")
//			  .roles("ADMIN").build();
//	  
//	  UserDetails user2=User
//			  .withDefaultPasswordEncoder()
//			  .username("deepu").password("deepu")
//			  .roles("USER").build();
//	  
//	  
//	  return new InMemoryUserDetailsManager(user1,user2);
//  }
//  
  
}
