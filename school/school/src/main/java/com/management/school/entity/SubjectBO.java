package com.management.school.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_subjectbo")
public class SubjectBO {
	
	
	
	    public SubjectBO(Integer id, String name, String code, DepartmentBO department, TeacherBO teacher,
			List<StudentBO> students) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.department = department;
		this.teacher = teacher;
		this.students = students;
	}
	    
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="subject_id")
		private Integer id;
		
		
	    private String name;
	    private String code;
	    
	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private DepartmentBO department;
	    
	    @ManyToOne
	    @JoinColumn(name = "teacher_id")
	    private TeacherBO teacher;
	    
	    @ManyToMany
	    @JoinTable(
	        name = "student_subject",
	        joinColumns = @JoinColumn(name = "subject_id"),
	        inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	    private List<StudentBO> students;
	    
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
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public DepartmentBO getDepartment() {
			return department;
		}
		public void setDepartment(DepartmentBO department) {
			this.department = department;
		}
		public TeacherBO getTeacher() {
			return teacher;
		}
		public void setTeacher(TeacherBO teacher) {
			this.teacher = teacher;
		}
		public List<StudentBO> getStudents() {
			return students;
		}
		public void setStudents(List<StudentBO> students) {
			this.students = students;
		}
		
		@Override
		public String toString() {
			return "SubjectBO [id=" + id + ", name=" + name + ", code=" + code + ", department=" + department
					+ ", teacher=" + teacher + ", students=" + students + "]";
		}
	    
	    

	    

}
