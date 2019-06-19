package com.adweb.adweb.service;

import com.adweb.adweb.entity.ChoiceQuestion;

import java.util.List;

public interface HomeworkService {
    List<ChoiceQuestion> getHomeworkBySectionID(int sectionID);
//    List<ChoiceQuestion> getHomeworkBySectionIDAndStudentID(int sectionID,String studentID);
}
