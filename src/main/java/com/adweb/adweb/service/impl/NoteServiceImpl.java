package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.NoteDao;
import com.adweb.adweb.entity.Note;
import com.adweb.adweb.entity.NoteExample;
import com.adweb.adweb.entity.NoteKey;
import com.adweb.adweb.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;

    @Override
    public boolean addNote(Note record) {
        return noteDao.insert(record) == 1;
    }

    @Override
    public boolean modifyNote(Note record) {
        return noteDao.updateByPrimaryKeySelective(record) == 1;
    }

    @Override
    public List<Note> getAllNotes(NoteExample example) {
        return noteDao.selectByExampleWithBLOBs(example); // 用了Blob才能将content提取出来
    }

    @Override
    public boolean deleteNote(NoteExample example) {
        return noteDao.deleteByExample(example) == 1;
    }
}
