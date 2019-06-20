package com.adweb.adweb.service;

import com.adweb.adweb.entity.Course;
import com.adweb.adweb.entity.Student;
import com.adweb.adweb.entity.Theme;

import java.util.List;

public interface StudentService {
    Student getStuInfo(String studentID);
    List<Course> getMyCourse(String studentID);
}
