package com.adweb.adweb.controllor;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.service.CourseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping(value = "type/{typeName}",produces = "application/json;UT8-8")
    public String getCourseByType(@PathVariable() String typeName){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        List<Course> list=courseService.getCourseByType(typeName);
        jsonObject.put("dataList",list);
        return jsonObject.toString();
    }
}
