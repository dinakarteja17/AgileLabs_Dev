package com.agilelabs.service;

import java.util.List;

import com.agilelabs.dto.CoursesDTO;
import com.agilelabs.entity.CoursesEntity;

public interface CoursesService {

    CoursesEntity createCourse(CoursesDTO coursesDTO);

    CoursesEntity getCourseById(Long id);

    List<CoursesEntity> getAllCourses();

    CoursesEntity updateCourse(Long id, CoursesDTO coursesDTO);

    void deleteCourse(Long id);
}
