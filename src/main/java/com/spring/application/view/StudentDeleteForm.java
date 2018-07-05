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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class StudentDeleteForm extends FormLayout{

	private static final long serialVersionUID = 1L;
	
	private TextField studentId = new TextField("Student Id");
	private TextField studentName = new TextField("Student Name");
	
	private Button findStudent = new Button("Find");
	private Button delete = new Button("Delete");
	
	private HorizontalLayout findStudentLayout;
	
	@Autowired
	private Student student;
	
	private ComboBox<Integer> select = new ComboBox<>("Select Student");
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	EntityManager em;

	private VerticalLayout deleteLayout;
	
	@PostConstruct
	public void init() {
		
		findStudent.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		findStudentLayout = new HorizontalLayout();
		
		List<Student> students = studentRepo.findAll();
		
		ArrayList<Integer> studentId = new ArrayList<>();
		for(Student student : students) {
			studentId.add(student.getStudentId());
		}
		select.setItems(studentId);
		
		findStudent.addClickListener(event -> {
			
			deleteStudent();
		});

		findStudentLayout.addComponents(select, findStudent);
		addComponent(findStudentLayout);
		
		System.out.println("hello");
	}
	
	private void deleteStudent() {
		if(deleteLayout != null )
			removeComponent(deleteLayout);
		deleteLayout = new VerticalLayout();
		
		student = em.find(Student.class, select.getValue());
		
		studentId.setValue(String.valueOf(student.getStudentId()));
		studentName.setValue(student.getStudentName());
		
		delete.addClickListener(e -> {
			student.setStudentId(Integer.parseInt(studentId.getValue()));
	


			studentRepo.delete(student);
			Notification.show("Student Deleted");
		});
		
//		deleteLayout.removeAllComponents();
		//removeComponent(deleteLayout);
		deleteLayout.addComponents(studentId,studentName,delete);
		
		addComponent(deleteLayout);
	
	}
	
	 
	
}
