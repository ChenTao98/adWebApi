package com.adweb.adweb.JsonUtil;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MyJson extends JSONObject {
    public MyJson(){
        DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
    }
    @Override
    public String toString() {
        return toJSONString(this, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteDateUseDateFormat);
    }
}
