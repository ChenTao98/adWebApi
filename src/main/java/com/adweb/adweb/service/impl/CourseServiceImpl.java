package com.adweb.adweb.service.impl;

import com.adweb.adweb.JSONBean.course.CourseThemeJSONBean;
import com.adweb.adweb.JSONBean.course.CourseTypeJSONBean;
import com.adweb.adweb.dao.CourseDao;
import com.adweb.adweb.dao.CourseSelectionDao;
import com.adweb.adweb.dao.TeacherDao;
import com.adweb.adweb.dao.ThemeDao;
import com.adweb.adweb.entity.*;
import com.adweb.adweb.service.CourseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseSelectionDao courseSelectionDao;
    @Autowired
    private ThemeDao themeDao;
    @Autowired
    private TeacherDao teacherDao;
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
    public Course getCourseByIdAndStu(Integer id,String student_id) {
        int lastestSectionId;
        Course course = courseDao.getCourseDetailById(id);
        Boolean taked = false;
        int times = courseDao.judgeTaked(id,student_id);
        if(times ==1){
            taked = true;
        }
        if(taked){
             lastestSectionId = courseDao.findLatestSectionId(id,student_id);
        }else{
            lastestSectionId = -1;
        }
        course.setTeacherName(getTeacherNameById(course.getTeacherId()));

        course.setTaked(taked);
        course.setLastestSectionId(lastestSectionId);
        return course;
    }

    @Override
    public List<Theme> getAllTheme() {

        return themeDao.selectByExample(new ThemeExample());
    }
    @Override
    public List<Course> getCourseByThemeID(int themeID,String student_id ) {
        List<Course> list = courseDao.getCourseByThemeID(themeID);
        for(int i=0;i<list.size();i++){
            String teacherName = getTeacherNameById(list.get(i).getTeacherId());
            int lastestSectionId;
            Boolean taked = false;
            int times = courseDao.judgeTaked(list.get(i).getId(),student_id);
            if(times ==1){
                taked = true;
            }
            if(taked){
                lastestSectionId = courseDao.findLatestSectionId(list.get(i).getId(),student_id);
            }else{
                lastestSectionId = -1;
            }
            list.get(i).setTeacherName(teacherName);
            list.get(i).setTaked(taked);
            list.get(i).setLastestSectionId(lastestSectionId);
        }
        return list;
    }
    @Override
    public void course_selection(String studentId,int courseId){
        Choose_course choose_course  = new Choose_course(0,0,0,studentId,courseId);

        courseSelectionDao.add(choose_course);
    }


    //获取课程列表
    @Override
    public List<JSONObject> getAllCourseOrderByType(String student_id){
        List<JSONObject> list = new ArrayList();
        List<CourseTypeJSONBean> list1 = getAllType();
        for (int i=0;i<list1.size();i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type",list1.get(i).getType());
            List<Course> list2 = getCourseByType(list1.get(i).getType());
            for(int j=0;j<list2.size();j++){
                String teacherName = getTeacherNameById(list2.get(j).getTeacherId());
                int lastestSectionId;
                Boolean taked = false;
                int times = courseDao.judgeTaked(list2.get(j).getId(),student_id);
                if(times ==1){
                    taked = true;
                }
                if(taked){
                    lastestSectionId = courseDao.findLatestSectionId(list2.get(j).getId(),student_id);
                }else{
                    lastestSectionId = -1;
                }
                list2.get(j).setTeacherName(teacherName);
                list2.get(j).setTaked(taked);
                list2.get(j).setLastestSectionId(lastestSectionId);
            }
            jsonObject.put("courseList",list2);
            list.add(jsonObject);

        }
        return list;

    }
    //获取分类课程
    @Override
    public List<Course> getCourseByTypeAndStu(String type,String student_id){
        List<Course> list = getCourseByType(type);
        for(int i=0;i<list.size();i++){
            String teacherName = getTeacherNameById(list.get(i).getTeacherId());
            int lastestSectionId;
            Boolean taked = false;
            int times = courseDao.judgeTaked(list.get(i).getId(),student_id);
            if(times ==1){
                taked = true;
            }
            if(taked){
                lastestSectionId = courseDao.findLatestSectionId(list.get(i).getId(),student_id);
            }else{
                lastestSectionId = -1;
            }
            list.get(i).setTeacherName(teacherName);
            list.get(i).setTaked(taked);
            list.get(i).setLastestSectionId(lastestSectionId);
        }
        return list;
    }

    @Override
    public  String getTeacherNameById(String id){
        return  teacherDao.getNameById(id);
    }
}
