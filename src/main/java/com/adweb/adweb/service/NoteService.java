package com.adweb.adweb.service;

import com.adweb.adweb.entity.Note;
import com.adweb.adweb.entity.NoteExample;
import com.adweb.adweb.entity.NoteKey;

import java.util.List;

public interface NoteService {
    /**
     * 新增记录
     * */
    boolean addNote(Note record);

    /**
     * 修改笔记
     * */
    boolean modifyNote(Note record);

    /**
     * 获取所有笔记
     * */
    List<Note> getAllNotes(NoteExample example);

    /**
     * 删除笔记
     * */
    boolean deleteNote(NoteExample example);

}
