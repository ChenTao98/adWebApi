package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.CourseSelectionDao;
import com.adweb.adweb.dao.StudentDao;
import com.adweb.adweb.dao.TeacherDao;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.entity.Student;
import com.adweb.adweb.entity.Teacher;
import com.adweb.adweb.entity.UpdateUser;
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
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Student getStuInfo(String studentID){
        return studentDao.selectByPrimaryKey(studentID);
    }
    @Override
    public List<Course> getMyCourse(String studentID){
        List<Course> courses = courseSelectionDao.getMyCourse(studentID);
        for (int i=0;i<courses.size();i++){
            courses.get(i).setTeacherName(getTeacherNameById(courses.get(i).getTeacherId()));
        }
        return courses;
    }

    @Override
    public  String getTeacherNameById(String id){
        return  teacherDao.getNameById(id);
    }
    @Override
    public void updateUser(String user_id, UpdateUser updateUser){

        if(studentDao.judgeStudent(user_id)==1){
            studentDao.updateStudent(new Student(user_id,updateUser.getName(),updateUser.getEmail(),updateUser.getSex(),0));
        }else{
            studentDao.addStudent(new Student(user_id,updateUser.getName(),updateUser.getEmail(),updateUser.getSex(),0));
        }
    }
}
