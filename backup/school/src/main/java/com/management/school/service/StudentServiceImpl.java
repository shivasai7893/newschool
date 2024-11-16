package com.management.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.dao.StudentDao;
import com.management.school.dao.SubjectDao;
import com.management.school.entity.StudentBO;
import com.management.school.entity.SubjectBO;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

	
	@Override
	public StudentBO addStudent(StudentBO student) {
	    return studentDao.save(student);
	}


	@Override
	public StudentBO updateStudent(StudentBO student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentDao.deleteById(id.longValue());
		
	}

	@Override
	public StudentBO getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id.longValue()).orElse(null);
	}

	@Override
	public List<StudentBO> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public void enrollStudentInSubject(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		
		  StudentBO student = studentDao.findById(studentId.longValue()).orElseThrow();
	        SubjectBO subject = subjectDao.findById(subjectId.longValue()).orElseThrow();

	        student.getSubjects().add(subject);
	        studentDao.save(student);
		
	}

}
