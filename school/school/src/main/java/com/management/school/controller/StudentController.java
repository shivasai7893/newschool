package com.management.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.entity.StudentBO;
import com.management.school.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	  @PostMapping
	    public ResponseEntity<StudentBO> addStudent(@RequestBody StudentBO student) {
	        StudentBO newStudent = studentService.addStudent(student);
	        return ResponseEntity.ok(newStudent);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<StudentBO> updateStudent(@PathVariable Integer id, @RequestBody StudentBO student) {
	        student.setId(id);
	        StudentBO updatedStudent = studentService.updateStudent(student);
	        return ResponseEntity.ok(updatedStudent);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
	        studentService.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<StudentBO> getStudentById(@PathVariable Integer id) {
	        StudentBO student = studentService.getStudentById(id);
	        return ResponseEntity.ok(student);
	    }

	    @GetMapping
	    public ResponseEntity<List<StudentBO>> getAllStudents() {
	        List<StudentBO> students = studentService.getAllStudents();
	        return ResponseEntity.ok(students);
	    }

	    @PostMapping("/{studentId}/enroll/{subjectId}")
	    public ResponseEntity<Void> enrollStudentInSubject(@PathVariable Integer studentId, @PathVariable Integer subjectId) {
	        studentService.enrollStudentInSubject(studentId, subjectId);
	        return ResponseEntity.ok().build();
	        
	    }
	

}
