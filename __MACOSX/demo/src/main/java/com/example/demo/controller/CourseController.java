package com.example.demo.controller;
import com.example.demo.model.*;
import com.example.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*") // 允許 Angular 預設的 4200 port 存取

public class CourseController {

	@Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getCoursesByCountry(@RequestParam Integer countryId) {
        return courseRepository.findByCountryId(countryId);
    }
    
    @GetMapping("{id}/image")
    public ResponseEntity<byte[]> getCourseImage(@PathVariable Integer id){
    	Course course = courseRepository.findById(id).orElse(null);
    	
    	if (course != null && course.getImage()!=null) {
    		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(course.getImage());
    	}
    	return ResponseEntity.notFound().build();
    }
    

    


}
