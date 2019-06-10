package com.adweb.adweb.service;

import com.adweb.adweb.JSONBean.course.CourseTypeJSONBean;
import com.adweb.adweb.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByType(String type);

    List<CourseTypeJSONBean> getAllType();
    Course getCourseById(Integer id);
}
