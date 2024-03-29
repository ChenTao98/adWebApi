package com.adweb.adweb.dao;

import com.adweb.adweb.JSONBean.course.CourseThemeJSONBean;
import com.adweb.adweb.JSONBean.course.CourseTypeJSONBean;
import com.adweb.adweb.entity.Course;
import com.adweb.adweb.entity.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface CourseDao {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    //以下为个人自己添加
    List<CourseTypeJSONBean> getAllType();
    Course getCourseDetailById(Integer courseId);


    List<CourseThemeJSONBean> getAllTheme();

    List<Course> getCourseByThemeID(int themeID);

    //Ct修改
    int judgeTaked(@Param("course_id") int course_id, @Param("student_id") String student_id);

    int findLatestSectionId(@Param("course_id")int course_id, @Param("student_id")String student_id);

    int getCredit(int course_id);


}