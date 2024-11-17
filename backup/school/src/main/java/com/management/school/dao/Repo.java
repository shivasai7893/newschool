package com.management.school.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.management.school.entity.usertelusko;

@EnableJpaRepositories 
public interface Repo extends JpaRepository<usertelusko,Integer>{
	
	Optional<usertelusko> findByName(String username);

}
