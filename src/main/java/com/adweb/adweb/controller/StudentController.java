package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;

import com.adweb.adweb.entity.Student;
import com.adweb.adweb.entity.UpdateUser;
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
//1.获取学生信息
    @GetMapping(value = "",produces = "application/json;UTF-8")
    public String getStuInfo(@RequestHeader(name="openId") String studentID){
        Student stu;
        try{
            stu=studentService.getStuInfo(studentID);
        }catch (Exception e){
            JSONObject jsonObject=new MyJson();
            jsonObject.put("errorCode",2001);
            jsonObject.put("message","用户不存在");
            return jsonObject.toString();
        }
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("data",stu);
        return jsonObject.toString();
    }
    //更新学生信息
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String updateStuInfo( @RequestHeader(name="openId") String studentID,@RequestBody UpdateUser updateUser){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        studentService.updateUser(studentID,updateUser);
        return jsonObject.toString();
    }
}
