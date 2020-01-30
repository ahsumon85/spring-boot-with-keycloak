
package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.spring.dto.StudentDTO;
import com.spring.entity.StudentEntity;
import com.spring.repo.StudentRepo;


@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;


	public void saveOrUpdateStudent(StudentDTO studentDTO) {
		StudentEntity student =new StudentEntity();
		BeanUtils.copyProperties(studentDTO, student);
		studentRepo.save(student);
		
	}
	
	
	public List<StudentDTO> findAllStudents() throws Exception{
		List<StudentEntity> studentList=new ArrayList<>();
		List<StudentDTO> studentDTOList=new ArrayList<>();
		studentList=studentRepo.findAll();
		for(StudentEntity student:studentList) {
			StudentDTO studentDTO=new StudentDTO();
			BeanUtils.copyProperties(student, studentDTO);
			studentDTOList.add(studentDTO);
			
		}
		return studentDTOList;
	}
	
	
	
	public StudentDTO findByStudentID(Long studentID) {
		StudentDTO studentDTO=new StudentDTO();
		StudentEntity student=new StudentEntity();
		student=studentRepo.findOne(studentID);
		BeanUtils.copyProperties(student, studentDTO);
		return studentDTO;	
		}
	
	public void deleteStudent(StudentDTO studentDTO) {
		studentRepo.delete(studentDTO.getStudentID());		
	}


}
