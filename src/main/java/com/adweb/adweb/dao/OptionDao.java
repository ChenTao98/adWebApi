package com.adweb.adweb.dao;

import com.adweb.adweb.entity.CollectionKey;
import com.adweb.adweb.entity.Knowledge;
import com.adweb.adweb.entity.Option;
import com.adweb.adweb.entity.OptionExample;

import java.util.ArrayList;
import java.util.List;

import com.adweb.adweb.entity.resEntity.ResKnowledge;
import com.adweb.adweb.service.CollectionService;
import com.adweb.adweb.service.KnowledgeService;
import com.adweb.adweb.utils.ApiResult;
import com.adweb.adweb.utils.StringUtil;
import com.adweb.adweb.utils.errorCode.ErrorCode;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

public interface OptionDao {
    long countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Option record);

    int insertSelective(Option record);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);

    List<Option> selectOptionByQuestionID(int question_id);



}