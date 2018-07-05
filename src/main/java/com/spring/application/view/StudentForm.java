package com.spring.application.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.application.model.Student;
import com.spring.application.model.Teacher;
import com.spring.application.repository.StudentRepository;
import com.spring.application.repository.TeacherRepository;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class StudentForm extends FormLayout{

	private TextField studentId = new TextField("Student Id");
	private TextField studentName = new TextField("Student Name");
	
	private Button save = new Button("Save");
	
//	@Autowired
//	private Student student;
//	
//	@Autowired
//	private Teacher teacher;
	
	private ComboBox<Integer> select = new ComboBox<>("Select Teacher");
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	EntityManager em;
	
	@PostConstruct
	public void init() {
		save.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		HorizontalLayout buttonLayout = new HorizontalLayout(save);
		
		List<Teacher> teachers = teacherRepository.findAll();
		ArrayList<Integer> teacherId = new ArrayList<>();
		for(Teacher teacher : teachers) {
			teacherId.add(teacher.getTeacherid());
		}
		
		select.setItems(teacherId);
		
		Student student = new Student();
		
		save.addClickListener(e -> {
			
			student.setStudentId(Integer.parseInt(studentId.getValue()));
			
			student.setStudentName(studentName.getValue());
			Teacher teacher = em.find(Teacher.class, select.getValue());

			student.setTeacher(teacher);
			studentRepo.save(student);
			Notification.show("Student Saved");

		});
		addComponents(studentId, studentName, select, buttonLayout);
		
		System.out.println("hello");
	}
	 
	
}
