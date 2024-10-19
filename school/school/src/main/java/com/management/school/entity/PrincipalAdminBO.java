package com.management.school.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_principaladminbo")
public class PrincipalAdminBO {
	
	
	
	    public PrincipalAdminBO(Integer id, String name, String email, String phone, String role, LocalDate hireDate,
			Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	    
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="principaladmin_id")
		private Integer id;
		
		
	    private String name;
	    private String email;
	    private String phone;
	    private String role; // Principal or Admin
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
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
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
			return "PrincipalAdminBO [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", role="
					+ role + ", hireDate=" + hireDate + ", salary=" + salary + "]";
		}
	        

}
