package com.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.application.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
