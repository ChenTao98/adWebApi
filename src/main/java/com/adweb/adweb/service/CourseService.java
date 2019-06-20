package com.adweb.adweb.service;

import com.adweb.adweb.JSONBean.course.CourseThemeJSONBean;
import com.adweb.adweb.JSONBean.course.CourseTypeJSONBean;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.entity.Theme;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByType(String type);

    List<CourseTypeJSONBean> getAllType();
    Course getCourseById(Integer id);


    List<Theme> getAllTheme();
    List<Course> getCourseByThemeID(int themeID);
    Course getCourseByIdAndStu(Integer id,String student_id);
    List getAllCourseOrderByType(String student_id);
    void course_selection(String studentId,int courseId);
    List<Course> getCourseByTypeAndStu(String type,String student_id);

}
