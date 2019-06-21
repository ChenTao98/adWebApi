package com.adweb.adweb.service;

import com.adweb.adweb.entity.ChoiceQuestion;
import com.adweb.adweb.entity.Question;

import java.util.List;

public interface HomeworkService {
    List<ChoiceQuestion> getHomeworkBySectionID(int sectionID,String openID);

}