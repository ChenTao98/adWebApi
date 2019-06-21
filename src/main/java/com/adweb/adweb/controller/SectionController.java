package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;
import com.adweb.adweb.entity.HomeworkCommit;
import com.adweb.adweb.service.HomeworkService;
import com.adweb.adweb.service.KnowledgeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("section")
public class SectionController {
    @Autowired
    private KnowledgeService knowledgeService;
    
    @Autowired
    private HomeworkService homeworkService;
    //9获得小节所有知识点
    @GetMapping(value = "{section_id}/knowledge",produces = "application/json;utf-8")
    public String course_selection(@PathVariable() int section_id){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",knowledgeService.getKnowledgeBySectionId(section_id));

        return jsonObject.toString();
    }
    //10获得小节的作业题
    @GetMapping(value = "{section_id}/question",produces = "application/json;utf-8")
    public String course_selection(@PathVariable() int section_id,@RequestHeader("openId") String open_id){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",homeworkService.getHomeworkBySectionID(section_id, open_id));

        return jsonObject.toString();
    }
    //提交作业
    @PostMapping(value = "{section_id}/question",produces = "application/json;utf-8")
    public String course_selection(@RequestBody HomeworkCommit homeworkCommit){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        homeworkService.commit(homeworkCommit);
        return jsonObject.toString();
    }

}