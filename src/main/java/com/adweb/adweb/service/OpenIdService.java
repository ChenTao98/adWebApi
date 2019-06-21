package com.adweb.adweb.service;

public interface OpenIdService {
    /**
     * 通过code获取openId
     * */
    String getOpenIdByCode(String code);
}
