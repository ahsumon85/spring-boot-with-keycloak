
package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.TeacherDTO;
import com.spring.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(path="/saveTeacher", method=RequestMethod.POST)
	public String saveTeacher(TeacherDTO teacherDTO){
		teacherService.saveOrUpdate(teacherDTO);
		return "redirect:/teacher";
		
	}
	
	@RequestMapping(path="/teacher", method=RequestMethod.GET)
	public String teacher(Model model){
			model.addAttribute("teacherDTO", new TeacherDTO());
		return "teacher";
		
	}
	
	@RequestMapping(path="/allTeachers", method=RequestMethod.GET)
	public String showTeacher(Model model){
		try{
			model.addAttribute("teachers", teacherService.findAllTeachers());
			
		}catch (Exception e) {
			
		}
		return "teacherList";
		
	}
	
	@RequestMapping(path="/teacher/edit/{teacherID}", method=RequestMethod.GET)
	public String editTeacher(Model model, @PathVariable(value="teacherID") Long teacherID){
		
		try{
			model.addAttribute("teacherDTO", teacherService.findByTeacherID(teacherID));
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "teacher";
		
	}
	
	@RequestMapping(path="/teacher/delete/{teacherID}", method=RequestMethod.GET)
	public String deleteStudent(Model model, @PathVariable(value="teacherID")Long teacherID){
		try{
			TeacherDTO teacherDTO=new TeacherDTO();
			teacherDTO.setTeacherID(teacherID);
			teacherService.deleteTeacher(teacherDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/allTeachers";
		
	}

	
}
