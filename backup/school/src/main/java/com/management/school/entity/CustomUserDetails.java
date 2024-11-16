package com.management.school.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetails extends Users implements UserDetails {

	
	
	public CustomUserDetails(final Users users)
	{
		super(users);
	}
	//UserDetails-->Sprinboot predefined class
	
	//Users -> Its our database @Entity (users)
	
	//CustomUserDetails ==> It will take the data from database and give to UserDetails springboot class.
	@Override public Collection<? extends GrantedAuthority> getAuthorities() { 
		return getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole())) 
				.collect(Collectors.toList()); }
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}