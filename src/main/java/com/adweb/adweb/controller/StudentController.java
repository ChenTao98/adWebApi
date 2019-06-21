package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;

import com.adweb.adweb.entity.Student;
import com.adweb.adweb.entity.UpdateUser;
import com.adweb.adweb.service.CourseService;
import com.adweb.adweb.service.OpenIdService;
import com.adweb.adweb.service.StudentService;
import com.adweb.adweb.utils.ApiResult;
import com.adweb.adweb.utils.StringUtil;
import com.adweb.adweb.utils.errorCode.ErrorCode;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private OpenIdService openIdService;


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

    /**
     * 获取openId
     * */
    @RequestMapping(value = "/login/code", method = RequestMethod.POST,
                consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String getOpenId(@RequestBody JSONObject jsonParam) {
        String code = jsonParam.getString("code");
        if (StringUtil.isEmpty(code)) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }
        LOGGER.info("code: {}", code);

        String openId = openIdService.getOpenIdByCode(code);
        if (StringUtil.isEmpty(openId)) {
            return ApiResult.writeError(ErrorCode.GET_OPEN_ID_FAILED);
        }
        Map<String, String> data = new HashMap<>();
        data.put("openId", openId);
        return ApiResult.writeData(data);
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
