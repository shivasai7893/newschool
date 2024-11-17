package com.management.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.school.dao.UserRepo;
import com.management.school.entity.UserPrincipal;
import com.management.school.entity.Users;
import com.management.school.entity.usertelusko;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		usertelusko user=userrepo.findByName(username);
		
		if(user==null)
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}
	
	

}
