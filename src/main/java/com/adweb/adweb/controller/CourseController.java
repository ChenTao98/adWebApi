package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.service.CourseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    //选课
    @RequestMapping(value = "taked/",method = RequestMethod.PUT,produces = "application/json;utf-8")
    public String course_selection(@RequestParam("courseId") int courseId,@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        System.out.println(studentID);
        System.out.println(courseId);
        courseService.course_selection(studentID,courseId);
        return jsonObject.toString();
    }
    @GetMapping(value = "type/{typeName}",produces = "application/json;UTF-8")
    public String getCourseByType(@PathVariable() String typeName){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        List<Course> list=courseService.getCourseByType(typeName);
        jsonObject.put("dataList",list);
        return jsonObject.toString();
    }
    @GetMapping(value = "type",produces = "application/json;UTF-8")
    public String getAllType(){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",courseService.getAllType());
        return jsonObject.toString();
    }
    @GetMapping(value = "{id}",produces = "application/json;UT8-8")
    public String getCourseById(@PathVariable()Integer id){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("data",courseService.getCourseById(id));
        return jsonObject.toString();
    }
    @GetMapping(value = "theme",produces = "application/json;UT8-8")
    public String getAllTheme(){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",courseService.getAllTheme());
        return jsonObject.toString();
    }
    @GetMapping(value = "theme/{themeID}",produces = "application/json;UT8-8")
    public String getAllCourseByThemeID(@PathVariable() int themeID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",courseService.getCourseByThemeID(themeID));
        return jsonObject.toString();
    }
//    @PutMapping(value = "theme/{themeID}", produces = "application/json;UT8-8")
//    public String getAllCourseByThemeID(@PathVariable() int themeID){
//        JSONObject jsonObject=new MyJson();
//        JsonUtils.setSuccess(jsonObject);
//        jsonObject.put("dataList",courseService.getCourseByThemeID(themeID));
//        return jsonObject.toString();
//    }


}
