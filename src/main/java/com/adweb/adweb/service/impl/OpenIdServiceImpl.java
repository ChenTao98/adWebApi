package com.adweb.adweb.service.impl;

import com.adweb.adweb.service.OpenIdService;
import com.adweb.adweb.utils.ApiHttp;
import com.adweb.adweb.utils.StringUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OpenIdServiceImpl implements OpenIdService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenIdServiceImpl.class);
    private static final String APP_ID = "wx74e4dde03e2bbfdc";
    private static final String APP_SECRET = "55e421ac78fb7fcc27898d0f10304783";

    @Override
    public String getOpenIdByCode(String code) {
        JSONObject requestRet = getSessionKeyAndIdByCode(code);
        LOGGER.info("requestRet: \n{}", requestRet.toString());

        if(requestRet.getIntValue("errcode") > 0)
            return null;

        String openId = requestRet.getString("openid");
        if(StringUtil.isEmpty(openId))
            return null;

        return openId;
    }

    private JSONObject getSessionKeyAndIdByCode(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + APP_ID + "&secret=" + APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        JSONObject ret = JSONObject.parseObject(ApiHttp.doGet(url));
        return ret;
    }


}
