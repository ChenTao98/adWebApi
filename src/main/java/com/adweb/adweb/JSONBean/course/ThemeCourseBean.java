package com.adweb.adweb.JSONBean.course;

import com.adweb.adweb.entity.Course;

import java.util.List;

public class ThemeCourseBean {
    private int id;
    private String imageUrl;
    private String name;
    private String summary;
    private List<Course> courseList;

    public ThemeCourseBean(int id, String imageUrl, String name, String summary, List<Course> courseList) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.summary = summary;
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
