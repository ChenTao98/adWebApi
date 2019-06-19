package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.ChoiceQuestionDao;
import com.adweb.adweb.entity.ChoiceQuestion;
import com.adweb.adweb.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private ChoiceQuestionDao choiceQuestionDao;
    @Override
    public List<ChoiceQuestion> getHomeworkBySectionID(int sectionID){
        return choiceQuestionDao.getHomeworkBySectionID(sectionID);
    }
//    @Override
//    public List<ChoiceQuestion> getHomeworkBySectionIDAndStudentID(int sectionID,String studentID){
//        return choiceQuestionDao.getHomeworkBySectionIDAndStudentID();
//    }
}
