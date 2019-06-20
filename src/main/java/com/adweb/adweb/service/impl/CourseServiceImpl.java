package com.adweb.adweb.service.impl;

import com.adweb.adweb.JSONBean.course.CourseThemeJSONBean;
import com.adweb.adweb.JSONBean.course.CourseTypeJSONBean;
import com.adweb.adweb.dao.CourseDao;
import com.adweb.adweb.dao.CourseSelectionDao;
import com.adweb.adweb.dao.ThemeDao;
import com.adweb.adweb.entity.*;
import com.adweb.adweb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseSelectionDao courseSelectionDao;
    @Autowired
    private ThemeDao themeDao;
    @Override
    public List<Course> getCourseByType(String type) {
        CourseExample courseExample=new CourseExample();
        courseExample.createCriteria().andTypeEqualTo(type);
//        courseExample.setOrderByClause("order_number");
        return courseDao.selectByExample(courseExample);
    }

    @Override
    public List<CourseTypeJSONBean> getAllType() {
        return courseDao.getAllType();
    }


    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseDetailById(id);
    }

    @Override
    public List<Theme> getAllTheme() {

        return themeDao.selectByExample(new ThemeExample());
    }
    public List<Course> getCourseByThemeID(int themeID) {

        return courseDao.getCourseByThemeID(themeID);
    }
    @Override
    public void course_selection(String studentId,int courseId){
        courseSelectionDao.add(new Choose_course(0,0,0,studentId,courseId));
    }

}
