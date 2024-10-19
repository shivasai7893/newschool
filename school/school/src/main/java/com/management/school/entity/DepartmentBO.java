package com.management.school.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_departmentbo")
public class DepartmentBO {
	
	
	
	public DepartmentBO(Integer id, String name, TeacherBO head, List<StudentBO> students, List<TeacherBO> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.head = head;
		this.students = students;
		this.teachers = teachers;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private Integer id;
	
    private String name;
    
    @OneToOne
    @JoinColumn(name = "head_id")
    private TeacherBO head;
    
    @OneToMany(mappedBy = "department")
    private List<StudentBO> students;
    
    @OneToMany(mappedBy = "department")
    private List<TeacherBO> teachers;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TeacherBO getHead() {
		return head;
	}
	public void setHead(TeacherBO head) {
		this.head = head;
	}
	public List<StudentBO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentBO> students) {
		this.students = students;
	}
	public List<TeacherBO> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherBO> teachers) {
		this.teachers = teachers;
	}
	
	
	@Override
	public String toString() {
		return "DepartmentBO [id=" + id + ", name=" + name + ", head=" + head + ", students=" + students + ", teachers="
				+ teachers + "]";
	}
    
    
    

    

}
