package com.management.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
		createdefaultdata();
	}
	
	public static void createdefaultdata()
	{
		createdefaultdataforDepartments();
	}
	public static void createdefaultdataforDepartments()
	{
		
	}

}
