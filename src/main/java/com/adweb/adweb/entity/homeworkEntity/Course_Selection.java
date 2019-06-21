package com.adweb.adweb.entity.homeworkEntity;

public class Course_Selection {
    int course_id;
    String open_id;
    int status;
    int chapter_id;
    int section_id;
    Course_Selection(){}

    public Course_Selection(int course_id, String open_id, int status, int chapter_id, int section_id) {
        this.course_id = course_id;
        this.open_id = open_id;
        this.status = status;
        this.chapter_id = chapter_id;
        this.section_id = section_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }
}
