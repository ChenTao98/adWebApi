package com.adweb.adweb.entity;

import java.util.ArrayList;

public class HomeworkCommit {
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public ArrayList<QuestionCommit> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<QuestionCommit> answerList) {
        this.answerList = answerList;
    }

    String openId;
    int courseId;
    int sectionId;
    int chapterId;
    ArrayList<QuestionCommit> answerList;
}
