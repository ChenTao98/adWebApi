package com.adweb.adweb.controller;

import com.adweb.adweb.entity.Note;
import com.adweb.adweb.entity.NoteExample;
import com.adweb.adweb.service.NoteService;
import com.adweb.adweb.utils.ApiResult;
import com.adweb.adweb.utils.StringUtil;
import com.adweb.adweb.utils.errorCode.ErrorCode;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;


    /**
     * 新增笔记
     * */
    @RequestMapping(value = "/add_note", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String addNote(@RequestBody JSONObject jsonParam) throws UnsupportedEncodingException {
        Note note = new Note();
        note.setUrl(jsonParam.getString("url"));
        note.setUserId(jsonParam.getString("userId"));
        String contentStr = jsonParam.getString("content");
        if (contentStr == null ) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }
        note.setContent(contentStr.getBytes("UTF-8"));
        if (StringUtil.isEmpty(note.getUrl()) || StringUtil.isEmpty(note.getUserId())
                || StringUtil.isEmpty(new String(note.getContent()))) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }

        // 插入note记录
        if (noteService.addNote(note)) {
            return ApiResult.writeSuccess();
        }

        return ApiResult.writeError(ErrorCode.ADD_NOTE_FAILED);
    }

    /**
     * 修改笔记
     * */
    @RequestMapping(value = "/modify_note", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String modifyNote(@RequestBody JSONObject jsonParam) throws UnsupportedEncodingException {
        Note note = new Note();
        note.setUrl(jsonParam.getString("url"));
        note.setUserId(jsonParam.getString("userId"));
        String contentStr = jsonParam.getString("content");
        if (contentStr == null ) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }
        note.setContent(contentStr.getBytes("UTF-8"));
        if (StringUtil.isEmpty(note.getUrl()) || StringUtil.isEmpty(note.getUserId())
                || StringUtil.isEmpty(new String(note.getContent()))) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }

        // 插入note记录
        if (noteService.modifyNote(note)) {
            return ApiResult.writeSuccess();
        }

        return ApiResult.writeError(ErrorCode.MODIFY_NOTE_FAILED);
    }

    /**
     * 获取笔记
     * */
    @RequestMapping(value = "/get_all", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String getAllNotes(@RequestBody JSONObject jsonParam) throws UnsupportedEncodingException {
        String userId = jsonParam.getString("userId");
        if (StringUtil.isEmpty(userId)) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }

        NoteExample example = new NoteExample();
        example.createCriteria().andUserIdEqualTo(userId);

        List<Note> notes = noteService.getAllNotes(example);
        List<HashMap<String , String>> notesReturn = new ArrayList<>();
        for (Note note: notes) {
            HashMap<String, String> map = new HashMap<>();
            map.put("url", note.getUrl());
            map.put("content", new String(note.getContent(), "UTF-8"));
            notesReturn.add(map);
        }
        return ApiResult.writeData(notesReturn, notesReturn.size());
    }

    /**
     * 删除笔记
     * */
    @RequestMapping(value = "/delete_note", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String deleteNote(@RequestBody JSONObject jsonParam) {
        String userId = jsonParam.getString("userId");
        String url = jsonParam.getString("url");
        if (StringUtil.isEmpty(userId) || StringUtil.isEmpty(url)) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }
        NoteExample example = new NoteExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.createCriteria().andUrlEqualTo(url);
        if (noteService.deleteNote(example)) {
            return ApiResult.writeSuccess();
        }
        return ApiResult.writeError(ErrorCode.DELETE_NOTE_FAILED);
    }

}
