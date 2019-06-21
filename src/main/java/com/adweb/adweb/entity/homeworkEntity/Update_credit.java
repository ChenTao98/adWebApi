package com.adweb.adweb.entity.homeworkEntity;

public class Update_credit {
    String open_id;
    int credit;
    Update_credit(){}
    public Update_credit(String open_id, int credit) {
        this.open_id = open_id;
        this.credit = credit;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
