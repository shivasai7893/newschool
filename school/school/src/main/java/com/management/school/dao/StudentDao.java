package com.management.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.school.entity.StudentBO;

@Repository
public interface StudentDao extends JpaRepository<StudentBO, Long> {
	

}
