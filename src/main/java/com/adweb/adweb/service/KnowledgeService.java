package com.adweb.adweb.service;

import com.adweb.adweb.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {
    /**
     * 通过knowledge_id获取knowledge
     * */
    Knowledge getKnowledgeByKnowledgeId(int knowledge_id);

    List<Knowledge> getKnowledgeBySectionId(int section_id);

}
