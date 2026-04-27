package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {
    // 根據國家 ID 查詢所有對應課程
    List<Course> findByCountryId(Integer countryId);

}
