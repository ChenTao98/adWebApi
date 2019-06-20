package com.adweb.adweb.entity;

public class Choose_course {
    /**
     * 课程完成状态 1表示已完成 0表示未完成
     */
    private Integer status;

    /**
     * 当前学到哪个章节的id
     */
    private Integer chapter;

    /**
     * 当前学到哪个小节
     */
    private Integer section_id;

    private String student_id;

    public Choose_course(Integer status, Integer chapter, Integer sectionId, String student_id, int course_id) {
        this.status = status;
        this.chapter = chapter;
        this.section_id = sectionId;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getSectionId() {
        return section_id;
    }

    public void setSectionId(Integer sectionId) {
        this.section_id = sectionId;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    private int course_id;
}
