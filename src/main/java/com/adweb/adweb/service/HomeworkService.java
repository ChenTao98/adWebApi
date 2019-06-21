package com.adweb.adweb.service;

import com.adweb.adweb.entity.ChoiceQuestion;
import com.adweb.adweb.entity.HomeworkCommit;
import com.adweb.adweb.entity.Question;

import java.util.List;
import java.util.Map;

public interface HomeworkService {
    List<ChoiceQuestion> getHomeworkBySectionID(int sectionID,String openID);
    void commit(HomeworkCommit homeworkCommit);

}