package com.management.school.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.management.school.entity.Users;

@EnableJpaRepositories 
public interface UsersRepository extends JpaRepository<Users,Integer>{
	
	Optional<Users> findByName(String username);

}
