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
@Table(name="tbl_studentbo")
public class StudentBO {
	
		
	public StudentBO(Integer id, String name, Integer age, String email, String phone, DepartmentBO department,
			List<SubjectBO> subjects, String address, LocalDate enrollmentDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.subjects = subjects;
		this.address = address;
		this.enrollmentDate = enrollmentDate;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer id;
	
	
    private String name;
    private Integer age;
    private String email;
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentBO department;
    
    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    ) 
    private List<SubjectBO> subjects;
    
    private String address;
    private LocalDate enrollmentDate;
    
    
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	@Override
	public String toString() {
		return "StudentBO [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", department=" + department + ", subjects=" + subjects + ", address=" + address + ", enrollmentDate="
				+ enrollmentDate + "]";
	}
    

}
