package com.adweb.adweb.entity;

public class QuestionAndStudent {
    private String open_id;

    public QuestionAndStudent(String open_id, int question_id) {
        this.open_id = open_id;
        this.question_id = question_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    private int question_id;
}
