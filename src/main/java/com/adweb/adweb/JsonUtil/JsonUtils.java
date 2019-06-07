package com.adweb.adweb.JsonUtil;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
    public static void setSuccess(JSONObject jsonObject){
        jsonObject.put("errorCode",0);
        jsonObject.put("message","成功");
    }
}
