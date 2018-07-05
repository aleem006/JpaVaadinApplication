package com.spring.application.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.application.model.Student;
import com.spring.application.repository.StudentRepository;
import com.spring.application.services.StudentRepositoryImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo") 
public class View extends UI{
	
	@Autowired
	StudentRepositoryImpl studentRepoImpl;
	
	private Grid<Student> studentGrid = new Grid<>(Student.class);
//	private Grid searchGrid = new Grid();
//	private TextField filter = new TextField("Filter by Name");
//	private StudentForm studentForm = new StudentForm(this);
	
	private TextField studentId = new TextField("Student Id");

	@Autowired
	StudentForm studentForm;
	
	@Autowired
	StudentDeleteForm deleteForm;
	
	@Autowired
	StudentRepository studentRepo;
	
	private VerticalLayout layout;
	private HorizontalLayout formLayout;
	private Label header;
	private HorizontalLayout labelLayout;
	private ComboBox<Integer> select = new ComboBox<>("Select Teacher");

	@Override
	protected void init(VaadinRequest request) {
		setLayout();
		header();
		addForm();
		
	}

	private void setLayout() {
		layout = new VerticalLayout();
		setContent(layout);
		
	}
	
	private void header() {
		labelLayout = new HorizontalLayout();
		header = new Label("List of Students");
		header.addStyleName(ValoTheme.LABEL_H1);
		header.addStyleName(ValoTheme.LABEL_COLORED);
		labelLayout.addComponent(header);
		layout.addComponents(labelLayout);
	}
	
	private void addForm() {
		formLayout = new HorizontalLayout();
		
		
		Button searchButton = new Button("Show All");
		searchButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
		studentGrid.setSelectionMode(SelectionMode.MULTI);
		searchButton.addClickListener(event -> {
			student();
		});
		
		Button saveButton = new Button("Save");
		saveButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		saveButton.addClickListener(event ->{
			save();
		});
		
		
		Button deleteButton = new Button("Delete");
		deleteButton.addStyleName(ValoTheme.BUTTON_DANGER);
		deleteButton.addClickListener(event ->{
			delete();
		});
		formLayout.addComponents(searchButton, deleteButton, saveButton);
		layout.addComponents(formLayout);
	}

	private void student() {
		List<Student> students = studentRepoImpl.findAllStudents();
		studentGrid.setItems(students);
		studentGrid.setWidth("100%");
		
		layout.removeAllComponents();
		layout.addComponents(header, formLayout,studentGrid);
	}
	
	private void save() {
		layout.removeAllComponents();
		layout.addComponents(header, formLayout, studentForm);
	}
	
	private void delete() {
		
		List<Student> students = studentRepo.findAll();
		
		ArrayList<Integer> studentId = new ArrayList<>();
		for(Student student : students) {
			studentId.add(student.getStudentId());
		}
//		select.setItems(studentId);

		
		layout.removeAllComponents(); 
		layout.addComponents(header,formLayout,deleteForm);
	
	}

}
