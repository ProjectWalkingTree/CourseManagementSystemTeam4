package com.cmc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.cmc.entity.Course;
import com.cmc.repository.CourseRepository;



@Service
public class CourseService {
	@Autowired
	
	private CourseRepository repo;
	
	public  void addCourse(Course c) {
		
		repo.save(c);
	}
	
	public List<Course> getAllCourse(){
		
		return repo.findAll();
		
	}
	
	public Course getCourseById(int id ) {
		
		Optional<Course> c=repo.findById(id);
		if (c.isPresent()) {
			return c.get();
		}
			return null;
		}
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	
	public Page<Course> getCourseByPaginate (int currentPage ,int size){
		
		
		Pageable p=PageRequest.of(currentPage, size);
		return repo.findAll(p);
	}
}
	
	

	

	
	
	
	
	


