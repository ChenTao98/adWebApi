package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.CourseDao;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.entity.CourseExample;
import com.adweb.adweb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> getCourseByType(String type) {
        CourseExample courseExample=new CourseExample();
        courseExample.createCriteria().andTypeEqualTo(type);
        return courseDao.selectByExample(courseExample);
    }
}
