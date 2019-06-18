package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.KnowledgeDao;
import com.adweb.adweb.entity.Knowledge;
import com.adweb.adweb.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Autowired
    private KnowledgeDao knowledgeDao;

    @Override
    public Knowledge getKnowledgeByKnowledgeId(int knowledge_id) {
        return knowledgeDao.selectByPrimaryKey(knowledge_id);
    }
}
