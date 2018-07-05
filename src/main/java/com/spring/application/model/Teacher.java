package com.spring.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
 
	@Id
	@Column(name = "teacher_id")
	private int teacherid;
 
	@Column(name = "teacher_name")
	private String teacherName;

	@OneToMany(mappedBy = "teacher")
	private List<Student> students = new ArrayList<>();
	
	public Teacher() {
	}
 
	public Teacher(int id, String name) {
		this.teacherid = id;
		this.teacherName = name;
	}

	@Override
	public String toString() {
		return String.format("Teacher[teacherId=%d, teacherName='%s']",teacherid, teacherName);
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}