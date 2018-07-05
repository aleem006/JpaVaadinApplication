package com.spring.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.application.model.Student;
import com.spring.application.model.Teacher;
import com.spring.application.repository.StudentRepository;
import com.spring.application.repository.TeacherRepository;

@Service
public class StudentRepositoryImpl {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	TeacherRepository teacherRepo;
	
	public List<Student> findAllStudents() {
		
		List<Student> students = studentRepo.findAll();
		System.out.println("Students List: => ");
        for(Student student : students)
        {
            System.out.println(student);
        }
		return students;
        
	}
	
	public void createStudent(Student entity) {

	}
	
	public void deleteStudent() {

	}

}
