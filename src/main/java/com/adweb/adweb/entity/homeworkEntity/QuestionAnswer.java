package com.adweb.adweb.entity.homeworkEntity;

public class QuestionAnswer {
    QuestionAnswer(){}


    String open_id;
    int question_id;
    int option_id;

    public QuestionAnswer(String open_id, int question_id, int option_id) {
        this.open_id = open_id;
        this.question_id = question_id;
        this.option_id = option_id;
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

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }
}
