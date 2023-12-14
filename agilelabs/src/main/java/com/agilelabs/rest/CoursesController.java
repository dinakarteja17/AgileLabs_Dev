package com.agilelabs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agilelabs.dto.CoursesDTO;
import com.agilelabs.entity.CoursesEntity;
import com.agilelabs.exception.DuplicateCourseException;
import com.agilelabs.serviceImpl.CoursesServiceImpl;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    private CoursesServiceImpl coursesService;

    @PostMapping("/createcourse")
    public ResponseEntity<String> createCourse(@RequestBody CoursesDTO coursesDTO) {
        try {
            CoursesEntity createdCourse = coursesService.createCourse(coursesDTO);
            return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
        } catch (DuplicateCourseException e) {
            // Course with the specified name already exists, return a custom message
            return new ResponseEntity<>("Course with the specified name already exists", HttpStatus.CONFLICT);
        }
    }


    @GetMapping("/getCourse/{id}")
    public ResponseEntity<CoursesEntity> getCourseById(@PathVariable Long id) {
        CoursesEntity course = coursesService.getCourseById(id);
        return course != null ?
                new ResponseEntity<>(course, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CoursesEntity>> getAllCourses() {
        List<CoursesEntity> courses = coursesService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<CoursesEntity> updateCourse(@PathVariable Long id, @RequestBody CoursesDTO coursesDTO) {
        CoursesEntity updatedCourse = coursesService.updateCourse(id, coursesDTO);
        return updatedCourse != null ?
                new ResponseEntity<>(updatedCourse, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
