package com.management.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.entity.TeacherBO;

public interface TeacherDao extends JpaRepository<TeacherBO,Long>{ //extends JpaRepository<TeacherBO, Long>{

}
