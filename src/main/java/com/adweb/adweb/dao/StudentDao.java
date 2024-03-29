package com.adweb.adweb.dao;

import com.adweb.adweb.entity.Student;
import com.adweb.adweb.entity.StudentExample;
import java.util.List;

import com.adweb.adweb.entity.homeworkEntity.Update_credit;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String openId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String openId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int getMyCredit(String student_id);

    void addStudent(Student student);

    void updateStudent(Student student);

    int judgeStudent(String open_id);

    void updateCredit(Update_credit update_credit);
}