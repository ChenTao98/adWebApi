package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.ChoiceQuestionDao;
import com.adweb.adweb.dao.OptionDao;
import com.adweb.adweb.dao.QuestionAnswerDao;
import com.adweb.adweb.entity.ChoiceQuestion;
import com.adweb.adweb.entity.Option;
import com.adweb.adweb.entity.Question;
import com.adweb.adweb.entity.QuestionAndStudent;
import com.adweb.adweb.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    ChoiceQuestionDao choiceQuestionDao;
    @Autowired
    OptionDao optionDao;
    @Autowired
    QuestionAnswerDao questionAnswerDao;

    @Override
    public List<ChoiceQuestion> getHomeworkBySectionID(int sectionID,String openID){
        List<ChoiceQuestion> questions = choiceQuestionDao.selectHomeworkBySectionID(sectionID);
        for(int i=0;i<questions.size();i++){
            List<Option> optionList = optionDao.selectOptionByQuestionID(questions.get(i).getId());
            questions.get(i).setOptionList(optionList);
            questions.get(i).setOpenId(openID);
            int answerId  = questionAnswerDao.selectOptionIDByStuAndQues(new QuestionAndStudent(openID,questions.get(i).getId()));
            questions.get(i).setAnswerId(answerId);
        }
        return  questions;
    }
}