package com.cmc.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.cmc.entity.Course;
import com.cmc.service.CourseService;



@Controller
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("/")
	public String home(Model m) 
	{
		return findPaginated(0, m);
	}

	@GetMapping("/add")
	public String addCourseForm() {
		return "add_Course";
	}
	
	
	@GetMapping("/#")
	public String home() {
		return "home";
	}

	@PostMapping("/register")
	public String courseRegister(@ModelAttribute Course c, HttpSession session) {
		service.addCourse(c);
		session.setAttribute("msg", "Course Added Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Course c = service.getCourseById(id);
		m.addAttribute("emp", c);
		return "edit";
	}

	@PostMapping("/update")
	public String updateCourse(@ModelAttribute Course c, HttpSession session) {
		service.addCourse(c);
		session.setAttribute("msg", "Course Data Update Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteCourse(@PathVariable int id, HttpSession session) {

		service.deleteCourse(id);
		session.setAttribute("msg", "Course Data Delete Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m) {

		Page<Course> courselist = service.getCourseByPaginate(pageno, 2);
		m.addAttribute("Course", courselist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", courselist.getTotalPages());
		m.addAttribute("totalItem", courselist.getTotalElements());
		return "index";
	}

}