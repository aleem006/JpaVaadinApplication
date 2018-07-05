package com.spring.application;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.application.model.Student;
import com.spring.application.model.Teacher;
import com.spring.application.repository.StudentRepository;
import com.spring.application.repository.TeacherRepository;
import com.spring.application.services.StudentRepositoryImpl;


@SpringBootApplication
public class JpaSpringApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepositoryImpl studentRepositoryImpl;  
	
	@Autowired
	TeacherRepository teacherRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
			
        
//        	studentRepositoryImpl.createStudent();
//    		studentRepositoryImpl.deleteStudent();
//		studentRepositoryImpl.findAllStudents();

     }
	
	
	
}
