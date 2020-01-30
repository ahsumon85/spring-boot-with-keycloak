
package com.spring.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.StudentDTO;
import com.spring.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:/home";
	}

	@RequestMapping(path = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(StudentDTO studentDTO) {
		studentService.saveOrUpdateStudent(studentDTO);
		return "redirect:/";
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String test(Principal principal, Model model) {
		model.addAttribute("studentDTO", new StudentDTO());
		model.addAttribute("username", principal.getName());
		return "home";
	}

	@RequestMapping(path = "/allStudents", method = RequestMethod.GET)
	public String saveStudent(Model model) {
		try {
			model.addAttribute("students", studentService.findAllStudents());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "studentList";
	}

	@RequestMapping(path = "/student/edit/{studentID}", method = RequestMethod.GET)
	public String editStudent(Model model, @PathVariable(value = "studentID") Long studentID) {
		try {
			model.addAttribute("studentDTO", studentService.findByStudentID(studentID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(path = "/student/delete/{studentID}", method = RequestMethod.GET)
	public String deleteStudent(Model model, @PathVariable(value = "studentID") Long studentID) {
		try {
			StudentDTO dto = new StudentDTO();
			dto.setStudentID(studentID);
			studentService.deleteStudent(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/allStudents";
	}

}
