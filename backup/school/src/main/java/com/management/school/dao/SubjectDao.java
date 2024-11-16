package com.management.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.entity.SubjectBO;

public interface SubjectDao extends JpaRepository<SubjectBO, Long>{

}
