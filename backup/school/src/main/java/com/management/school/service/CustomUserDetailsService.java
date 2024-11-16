package com.management.school.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.school.dao.UsersRepository;
import com.management.school.entity.CustomUserDetails;
import com.management.school.entity.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	 @Autowired
    private UsersRepository usersRepository;

   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> dbUserData = usersRepository.findByName(username);
        dbUserData.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return dbUserData.map(CustomUserDetails::new).get();
    }
}
 