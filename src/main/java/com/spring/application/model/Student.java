package com.spring.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
 
	@Id
	@Column(name = "student_id")
	private int studentid;
 
	@Column(name = "student_name")
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;

	protected Student() {
	}
 
	public Student(int id, String name) {
		this.studentid = id;
		this.studentName = name;
	}

	@Override
	public String toString() {
		return String.format("Student[studnetId=%d, studentName='%s', teacherName ='%s']", studentid, studentName, teacher.getTeacherName());
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}