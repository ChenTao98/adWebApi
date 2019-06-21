package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.*;
import com.adweb.adweb.entity.*;
import com.adweb.adweb.entity.homeworkEntity.Course_Selection;
import com.adweb.adweb.entity.homeworkEntity.QuestionAnswer;
import com.adweb.adweb.entity.homeworkEntity.Update_credit;
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
    @Autowired
    ChapterDao chapterDao;
    @Autowired
    SectionDao sectionDao;
    @Autowired
    CourseSelectionDao courseSelectionDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    CourseDao courseDao;



    @Override
    public List<ChoiceQuestion> getHomeworkBySectionID(int sectionID, String openID) {
        List<ChoiceQuestion> questions = choiceQuestionDao.selectHomeworkBySectionID(sectionID);
        for (int i = 0; i < questions.size(); i++) {
            List<Option> optionList = optionDao.selectOptionByQuestionID(questions.get(i).getId());
            questions.get(i).setOptionList(optionList);
            questions.get(i).setOpenId(openID);
            int answerId = questionAnswerDao.selectOptionIDByStuAndQues(new QuestionAndStudent(openID, questions.get(i).getId()));
            questions.get(i).setAnswerId(answerId);
        }
        return questions;
    }
    @Override
    public void commit(HomeworkCommit homeworkCommit){
        for (int i=0;i<homeworkCommit.getAnswerList().size();i++){
            questionAnswerDao.add(new QuestionAnswer(homeworkCommit.getOpenId(),homeworkCommit.getAnswerList().get(i).getQuestionId(),homeworkCommit.getAnswerList().get(i).getAnswerId()));
        }
        int max_chapter_id = chapterDao.findMaxChapterID(homeworkCommit.getCourseId());
        int max_section_id = sectionDao.findMaxSectionID(max_chapter_id);
        if(max_chapter_id== homeworkCommit.getChapterId() && max_section_id == homeworkCommit.getSectionId()){
            courseSelectionDao.update(new Course_Selection(homeworkCommit.getCourseId(),homeworkCommit.getOpenId(),1,homeworkCommit.getChapterId(),homeworkCommit.getSectionId()));
            int credits = studentDao.getMyCredit(homeworkCommit.getOpenId());
            int course_credits = courseDao.getCredit(homeworkCommit.getCourseId());
            studentDao.updateCredit(new Update_credit(homeworkCommit.getOpenId(),credits+ course_credits));
        }else{
            courseSelectionDao.update(new Course_Selection(homeworkCommit.getCourseId(),homeworkCommit.getOpenId(),0,homeworkCommit.getChapterId(),homeworkCommit.getSectionId()));
        }


    }
}