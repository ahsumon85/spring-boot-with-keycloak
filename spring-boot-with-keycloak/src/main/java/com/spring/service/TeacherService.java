
package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.spring.dto.StudentDTO;
import com.spring.dto.TeacherDTO;
import com.spring.entity.StudentEntity;
import com.spring.entity.TeacherEntity;
import com.spring.repo.StudentRepo;
import com.spring.repo.TeacherRepo;


@Service
@Transactional
public class TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	
	
	public void saveOrUpdate(TeacherDTO teacherDTO){
		TeacherEntity entity=new TeacherEntity();
		BeanUtils.copyProperties(teacherDTO, entity);
		teacherRepo.save(entity);
		
	}
	
	public List<TeacherDTO> findAllTeachers()throws Exception{
		List<TeacherEntity> teacherList=new ArrayList<>();
		List<TeacherDTO> teacherDTOList=new ArrayList<>();
		teacherList=teacherRepo.findAll();
		for(TeacherEntity e:teacherList){
			TeacherDTO teacherDTO=new TeacherDTO();
			BeanUtils.copyProperties(e, teacherDTO);
			teacherDTOList.add(teacherDTO);
		}
		return teacherDTOList;
	}

	public TeacherDTO findByTeacherID(Long teacherID) {
		TeacherDTO teacherDTO=new TeacherDTO();
		TeacherEntity entity=new TeacherEntity();
		entity=teacherRepo.findOne(teacherID);
		BeanUtils.copyProperties(entity, teacherDTO);
		
		
		return teacherDTO;
	}

	public void deleteTeacher(TeacherDTO teacherDTO) {
		teacherRepo.delete(teacherDTO.getTeacherID());
		
	}
	
	

}
