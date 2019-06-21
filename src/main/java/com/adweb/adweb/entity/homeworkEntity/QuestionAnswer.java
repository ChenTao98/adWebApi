package com.adweb.adweb.entity.homeworkEntity;

public class QuestionAnswer {
    QuestionAnswer(){}
    public QuestionAnswer(String open_id, int question_id, int answer_id) {
        this.open_id = open_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
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

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    String open_id;
    int question_id;
    int answer_id;
}
