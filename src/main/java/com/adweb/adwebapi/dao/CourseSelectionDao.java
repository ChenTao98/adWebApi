package com.adweb.adwebapi.dao;

import com.adweb.adwebapi.entity.CourseSelection;
import com.adweb.adwebapi.entity.CourseSelectionExample;
import com.adweb.adwebapi.entity.CourseSelectionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseSelectionDao {
    long countByExample(CourseSelectionExample example);

    int deleteByExample(CourseSelectionExample example);

    int deleteByPrimaryKey(CourseSelectionKey key);

    int insert(CourseSelection record);

    int insertSelective(CourseSelection record);

    List<CourseSelection> selectByExample(CourseSelectionExample example);

    CourseSelection selectByPrimaryKey(CourseSelectionKey key);

    int updateByExampleSelective(@Param("record") CourseSelection record, @Param("example") CourseSelectionExample example);

    int updateByExample(@Param("record") CourseSelection record, @Param("example") CourseSelectionExample example);

    int updateByPrimaryKeySelective(CourseSelection record);

    int updateByPrimaryKey(CourseSelection record);
}