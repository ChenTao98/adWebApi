package com.adweb.adweb.service;

import com.adweb.adweb.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByType(String type);
}
