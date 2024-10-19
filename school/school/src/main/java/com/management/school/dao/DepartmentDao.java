package com.management.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.entity.DepartmentBO;

public interface DepartmentDao extends JpaRepository<DepartmentBO, Long> {

}
