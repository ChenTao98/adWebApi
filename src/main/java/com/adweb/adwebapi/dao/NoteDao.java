package com.adweb.adwebapi.dao;

import com.adweb.adwebapi.entity.Note;
import com.adweb.adwebapi.entity.NoteExample;
import com.adweb.adwebapi.entity.NoteKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteDao {
    long countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(NoteKey key);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExampleWithBLOBs(NoteExample example);

    List<Note> selectByExample(NoteExample example);

    Note selectByPrimaryKey(NoteKey key);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExampleWithBLOBs(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKeyWithBLOBs(Note record);
}