package com.cmc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository <Course,Integer>{


}
