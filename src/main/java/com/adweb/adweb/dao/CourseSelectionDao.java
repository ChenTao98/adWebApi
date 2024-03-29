package com.adweb.adweb.dao;

import com.adweb.adweb.entity.*;

import java.util.List;

import com.adweb.adweb.entity.homeworkEntity.Course_Selection;
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

    List<Course> getMyCourse(String studentID);
    void add(Choose_course choose_course);

    int courseNumber(String student_id);

    void update(Course_Selection course_selection);
}