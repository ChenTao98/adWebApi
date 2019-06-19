package com.adweb.adweb.controller;

import com.adweb.adweb.entity.CollectionKey;
import com.adweb.adweb.entity.Knowledge;
import com.adweb.adweb.entity.resEntity.ResKnowledge;
import com.adweb.adweb.service.CollectionService;
import com.adweb.adweb.service.KnowledgeService;
import com.adweb.adweb.utils.ApiResult;
import com.adweb.adweb.utils.StringUtil;
import com.adweb.adweb.utils.errorCode.ErrorCode;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user/collections")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @Autowired
    private KnowledgeService knowledgeService;

    /**
     *  添加收藏
     * */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String addCollection(@RequestBody JSONObject data) {
        String open_id = data.getString("open_id");
        Integer knowledge_id = data.getInteger("knowledge_id");
        if (StringUtil.isEmpty(open_id) || knowledge_id == null) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }

        // 添加收藏
        CollectionKey record = new CollectionKey();
        record.setKnowledgeId(knowledge_id);
        record.setUserId(open_id);
        try {
            if (collectionService.addCollection(record)) {
                return ApiResult.writeSuccess();
            }
            return ApiResult.writeError(ErrorCode.ADD_COLLECTION_FAILED);
        } catch (DuplicateKeyException e) {
            return ApiResult.writeError(ErrorCode.ADD_COLLECTION_FAILED);
        }
    }

    /**
     * 获取收藏
     * */
    @RequestMapping(value = "/get_all", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String getCollections(@RequestBody JSONObject data) {
        String open_id = data.getString("open_id");
        if (StringUtil.isEmpty(open_id)) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }

        // 获取记录
        List<CollectionKey> collectionList = collectionService.getCollectionsByUserId(open_id);
        // 将记录中的knowledge_id转换为knowledge返回即可
        List<ResKnowledge> knowledgeList = new ArrayList<>();
        for (CollectionKey collection: collectionList) {
            Knowledge knowledge = knowledgeService.getKnowledgeByKnowledgeId(collection.getKnowledgeId());
            if (knowledge == null ) {
                knowledgeList.add(null);
                continue;
            }
            knowledgeList.add(new ResKnowledge(knowledge));
        }

        return ApiResult.writeData(knowledgeList, knowledgeList.size());
    }

    /**
     * 取消收藏
     * */
    @RequestMapping(value = "/delete/{knowledge_id}", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String deleteCollection(@RequestBody JSONObject jsonParam, @PathVariable Integer knowledge_id) {
        String open_id = jsonParam.getString("open_id");
        if (StringUtil.isEmpty(open_id)) {
            return ApiResult.writeError(ErrorCode.INFO_INCOMPLETE);
        }

        CollectionKey collection = new CollectionKey();
        collection.setUserId(open_id);
        collection.setKnowledgeId(knowledge_id);

        if (collectionService.deleteCollection(collection)) {
            return ApiResult.writeSuccess();
        }
        return ApiResult.writeError(ErrorCode.DELETE_COLLECTION_FAILED);
    }
}
