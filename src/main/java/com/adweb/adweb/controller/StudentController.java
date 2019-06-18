package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;

import com.adweb.adweb.service.CourseService;
import com.adweb.adweb.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "credit/{studentID}",produces = "application/json;UT8-8")
    public String getMyCredit(@PathVariable() String studentID){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        Integer credit=studentService.getMyCredit(studentID);
        jsonObject.put("credit",credit);
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
