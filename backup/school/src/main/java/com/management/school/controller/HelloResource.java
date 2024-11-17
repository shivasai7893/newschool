package com.management.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.service.CustomUserDetailsService;

@RequestMapping("rest/hello")
@RestController

public class HelloResource {
	
	@Autowired
	private CustomUserDetailsService custuserdetailservice;
	
	@GetMapping("/all")
	public String hello()
	{
		Object obj=custuserdetailservice.loadUserByUsername("shiva");
		System.out.println(obj);
		return "No Security.. You can see this page";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secure/control")
	public String securedAdmin()
	{
		return "Secured Page.. Only admin can see this page";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','GUEST')")
	@GetMapping("/secure/all")
	public String securedGuest()
	{
		return "Secured Page.. Both admin and Guest can see this page";
	}

}
