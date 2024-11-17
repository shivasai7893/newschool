package com.management.school.entity;

import java.util.Collection;
import java.util.Collections;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

public class UserPrincipal implements UserDetails{
	
	
	@Autowired
	private usertelusko user;
	
	public UserPrincipal(usertelusko user2)
	{
		this.user=user2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    // Correct syntax for creating SimpleGrantedAuthority
	    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
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
