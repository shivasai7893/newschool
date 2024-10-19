package com.management.school.service;

import java.util.List;

import com.management.school.entity.StudentBO;

public interface StudentService {
	
	
	    StudentBO addStudent(StudentBO student);
	    StudentBO updateStudent(StudentBO student);
	    void deleteStudent(Integer id);
	    StudentBO getStudentById(Integer id);
	    List<StudentBO> getAllStudents();
	    void enrollStudentInSubject(Integer studentId, Integer subjectId);

}
