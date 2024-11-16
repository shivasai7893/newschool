package com.management.school.entity;

import java.time.LocalDate;
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
@Table(name="tbl_teacherbo")
public class TeacherBO {
	
	public TeacherBO(Integer id, String name, String email, String phone, DepartmentBO department,
			List<SubjectBO> subjects, LocalDate hireDate, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	
		this.department = department;
		
		
		this.subjects = subjects;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	
	public TeacherBO() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private Integer id;
	
    private String name;
    private String email;
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentBO department;
    
    @ManyToMany
    @JoinTable(
        name = "teacher_subject",
        joinColumns = @JoinColumn(name = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<SubjectBO> subjects;
    
    
    private LocalDate hireDate;
    private Double salary;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public DepartmentBO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBO department) {
		this.department = department;
	}
	public List<SubjectBO> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectBO> subjects) {
		this.subjects = subjects;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "TeacherBO [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", department="
				+ department + ", subjects=" + subjects + ", hireDate=" + hireDate + ", salary=" + salary + "]";
	}

    
    
    

}
