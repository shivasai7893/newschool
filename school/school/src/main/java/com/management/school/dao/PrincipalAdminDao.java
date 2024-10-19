package com.management.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.entity.PrincipalAdminBO;

public interface PrincipalAdminDao extends JpaRepository<PrincipalAdminBO, Long>{

}
