package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;

import com.adweb.adweb.entity.Student;
import com.adweb.adweb.service.CourseService;
import com.adweb.adweb.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "",produces = "application/json;UT8-8")
    public String getMyCredit(@RequestHeader(name="openID") String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        Student stu=studentService.getStuInfo(studentID);
        jsonObject.put("data",stu);
        return jsonObject.toString();
    }
    @GetMapping(value = "course/{studentID}",produces = "application/json;UT8-8")
    public String getMyCourse(@PathVariable() String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",studentService.getMyCourse(studentID));
        return jsonObject.toString();
    }
}
