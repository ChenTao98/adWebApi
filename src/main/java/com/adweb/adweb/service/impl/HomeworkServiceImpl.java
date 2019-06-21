package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.*;
import com.adweb.adweb.entity.*;
import com.adweb.adweb.entity.homeworkEntity.Course_Selection;
import com.adweb.adweb.entity.homeworkEntity.QuestionAnswer;
import com.adweb.adweb.entity.homeworkEntity.Update_credit;
import com.adweb.adweb.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Homework getHomeworkBySectionID(int sectionID, String openID) {
        List<ChoiceQuestion> questions = choiceQuestionDao.selectHomeworkBySectionID(sectionID);
        for (int i = 0; i < questions.size(); i++) {
            List<Option> optionList = optionDao.selectOptionByQuestionID(questions.get(i).getId());
            questions.get(i).setOptionList(optionList);
            questions.get(i).setOpenId(openID);
            int answerId = questionAnswerDao.selectOptionIDByStuAndQues(new QuestionAndStudent(openID, questions.get(i).getId()));
            questions.get(i).setAnswerId(answerId);
        }
        int chapter_id = sectionDao.getChapterIdBySectionId(sectionID);
        int course_id = chapterDao.getCourseIdByChapterId(chapter_id);
        Homework homework = new Homework(openID,course_id,chapter_id,sectionID,questions);
        return homework;
    }
    @Override
    public void commit(HomeworkCommit homeworkCommit){
        String open_id = homeworkCommit.getOpenId();
        int course_id = homeworkCommit.getCourseId();
        int chapter_id = homeworkCommit.getChapterId();
        int section_id = homeworkCommit.getSectionId();
        ArrayList<QuestionCommit> questionCommits =homeworkCommit.getAnswerList();
        for (int i=0;i<homeworkCommit.getAnswerList().size();i++){
            System.out.println(open_id);
            System.out.println(questionCommits.get(i).getAnswerId());
            questionAnswerDao.addAnswer(new QuestionAnswer(open_id,questionCommits.get(i).getQuestionId(),questionCommits.get(i).getAnswerId()));
        }
        int max_chapter_id = chapterDao.findMaxChapterID(homeworkCommit.getCourseId());
        int max_section_id = sectionDao.findMaxSectionID(max_chapter_id);
        System.out.println(max_chapter_id);
        System.out.println(max_section_id);
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