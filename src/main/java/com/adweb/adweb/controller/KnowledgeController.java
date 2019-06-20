package com.adweb.adweb.controller;

import com.adweb.adweb.JsonUtil.JsonUtils;
import com.adweb.adweb.JsonUtil.MyJson;
import com.adweb.adweb.service.KnowledgeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("section")
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;
    //9获得小节所有知识点
    @GetMapping(value = "{section_id}/knowledge",produces = "application/json;utf-8")
    public String course_selection(@PathVariable() int section_id){
        JSONObject jsonObject=new MyJson();
        JsonUtils.setSuccess(jsonObject);
        jsonObject.put("dataList",knowledgeService.getKnowledgeBySectionId(section_id));

        return jsonObject.toString();
    }


}