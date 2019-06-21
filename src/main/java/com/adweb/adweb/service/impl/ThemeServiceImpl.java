package com.adweb.adweb.service.impl;

import com.adweb.adweb.dao.ThemeDao;
import com.adweb.adweb.entity.Theme;
import com.adweb.adweb.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeDao themeDao;
    @Override
    public Theme getThemeById(Integer id) {
        return themeDao.selectByPrimaryKey(id);
    }
}
