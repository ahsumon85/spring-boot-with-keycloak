package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.StudentEntity;
import com.spring.entity.TeacherEntity;

@Component
public interface TeacherRepo extends JpaRepository<TeacherEntity, Long>{

}
