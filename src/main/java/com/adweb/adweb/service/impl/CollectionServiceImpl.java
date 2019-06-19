package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.CollectionDao;
import com.adweb.adweb.entity.CollectionExample;
import com.adweb.adweb.entity.CollectionKey;
import com.adweb.adweb.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionDao collectionDao;

    @Override
    public boolean addCollection(CollectionKey record) {
        return collectionDao.insert(record) == 1;
    }

    @Override
    public List<CollectionKey> getCollectionsByUserId(String userId) {
        CollectionExample example = new CollectionExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return collectionDao.selectByExample(example);
    }

    @Override
    public boolean deleteCollection(CollectionKey record) {
        return collectionDao.deleteByPrimaryKey(record) == 1;
    }
}
