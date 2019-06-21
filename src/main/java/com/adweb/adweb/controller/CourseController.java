package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.service.CourseService;
import com.adweb.adweb.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    //2.选课
    @RequestMapping(value = "taked/",method = RequestMethod.PUT,produces = "application/json;utf-8")
    public String course_selection(@RequestParam("courseId") int courseId,@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        courseService.course_selection(studentID,courseId);
        return jsonObject.toString();
    }
    //3.获取课程分类
    @GetMapping(value = "type",produces = "application/json;UTF-8")
    public String getAllType(){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",courseService.getAllType());
        return jsonObject.toString();
    }
    //4.获取主题列表
    @GetMapping(value = "theme",produces = "application/json;UTF-8")
    public String getAllTheme(){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",courseService.getAllTheme());
        return jsonObject.toString();
    }
    //5.获取学生选课列表
    @GetMapping(value = "taked",produces = "application/json;UTF-8")
    public String getMyCourse(@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",studentService.getMyCourse(studentID));
        return jsonObject.toString();
    }

    //6.课程详细信息
    @GetMapping(value = "{id}",produces = "application/json;UTF-8")
    public String getCourseById(@PathVariable()Integer id,@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("data",courseService.getCourseByIdAndStu(id,studentID));
        return jsonObject.toString();
    }


    //7.获得课程列表
    @GetMapping(value = "",produces = "application/json;UTF-8")
    public String getCourseById(@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("data",courseService.getAllCourseOrderByType(studentID));
        return jsonObject.toString();
    }
    //8.获取分类课程
    @GetMapping(value = "type/{typeName}",produces = "application/json;UTF-8")
    public String getCourseByType(@PathVariable() String typeName,@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        List<Course> list=courseService.getCourseByTypeAndStu(typeName,studentID);
        jsonObject.put("dataList",list);
        return jsonObject.toString();
    }

    //11.根据主题id获取主题所有子课程
    @GetMapping(value = "theme/{themeID}",produces = "application/json;UTF-8")
    public String getAllCourseByThemeID(@PathVariable() int themeID,@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",courseService.getCourseByThemeID(themeID,studentID));
        return jsonObject.toString();
    }




}
