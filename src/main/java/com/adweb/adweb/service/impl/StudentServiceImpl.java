package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.CourseSelectionDao;
import com.adweb.adweb.dao.StudentDao;
import com.adweb.adweb.dao.TeacherAvatarDao;
import com.adweb.adweb.dao.TeacherDao;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.entity.Student;
import com.adweb.adweb.entity.Teacher;
import com.adweb.adweb.entity.UpdateUser;
import com.adweb.adweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.adweb.adweb.utils.PathUtil.COURSE_IMAGE_HTML;
import static com.adweb.adweb.utils.PathUtil.TEACHER_IMAGE_HTML;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseSelectionDao courseSelectionDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeacherAvatarDao teacherAvatarDao;
    @Override
    public Student getStuInfo(String studentID){
        Student student = studentDao.selectByPrimaryKey(studentID);
        student.setCourses(courseSelectionDao.courseNumber(studentID));

        return student;
    }
    @Override
    public List<Course> getMyCourse(String studentID){
        List<Course> list = courseSelectionDao.getMyCourse(studentID);
        for (int i=0;i<list.size();i++){
            list.get(i).setTeacherName(getTeacherNameById(list.get(i).getTeacherId()));
            list.get(i).setImageSrc(COURSE_IMAGE_HTML+list.get(i).getImageSrc());
            list.get(i).setTeacherAvatar(TEACHER_IMAGE_HTML+teacherAvatarDao.getAvatarByID(list.get(i).getTeacherId()));
        }
        return list;
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
