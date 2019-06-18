package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.CourseSelectionDao;
import com.adweb.adweb.dao.StudentDao;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseSelectionDao courseSelectionDao;
    @Override
    public Integer getMyCredit(String studentID){
        return studentDao.getMyCredit(studentID);
    }
    @Override
    public List<Course> getMyCourse(String studentID){
        return courseSelectionDao.getMyCourse(studentID);
    }
}
