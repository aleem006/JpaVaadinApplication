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
	TeacherRepository teacherRepository;
	
	public Optional<Student> findStudentById(int id) {
		return studentRepo.findById(id);
	}
	
	public void findAllStudents() {
		
		List<Student> students = studentRepo.findAll();
		System.out.println("Students List: => ");
        for(Student student : students)
        {
            System.out.println(student);
        }
        
	}
	
	
	public void createStudent() {
		
		Teacher teacher = new Teacher(23,"Sir");
		teacherRepository.save(teacher);
	    	Student student = new Student(12,"Aamir");
	    	Student student1 = new Student(13,"ali");
	    	student.setTeacher(teacher);
	    	studentRepo.save(student);
	    	student1.setTeacher(teacher);
	    	studentRepo.save(student1);
	    	
	}
	
	public void deleteStudent() {
		studentRepo.deleteById(12);
	}
	
}
