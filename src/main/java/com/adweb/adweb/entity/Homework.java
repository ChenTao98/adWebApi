package com.adweb.adweb.entity;

import java.util.List;

public class Homework {
    String openId;
    int courseId;
    int chapterId;

    public List<ChoiceQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<ChoiceQuestion> choiceQuestionList) {
        this.questionList = choiceQuestionList;
    }

    List<ChoiceQuestion> questionList;
    public Homework(){}

    public Homework(String openId, int courseId, int chapterId, int sectionId,List<ChoiceQuestion> choiceQuestions) {
        this.openId = openId;
        this.courseId = courseId;
        this.chapterId = chapterId;
        this.sectionId = sectionId;
        this.questionList = choiceQuestions;
    }

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

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    int sectionId;

}
