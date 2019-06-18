package com.adweb.adweb.service;

import com.adweb.adweb.entity.CollectionKey;

import java.util.List;

public interface CollectionService {
    /**
     * 添加收藏
     * 成功返回真，失败返回假
     * */
    boolean addCollection(CollectionKey record);

    /**
     * 获取收藏记录
     * */
    List<CollectionKey> getCollectionsByUserId(String userId);

    /**
     * 取消收藏
     * */
    boolean deleteCollection(CollectionKey record);
}
