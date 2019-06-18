package com.adweb.adweb.utils.errorCode;

public enum ErrorCode {
    SUCCESS(0, "成功！"),

    // 公用
    INFO_INCOMPLETE(1001, "信息不完整"),

    // 用户相关
        // 收藏和笔记部分
        ADD_COLLECTION_FAILED(2001, "添加收藏失败！"),
        DELETE_COLLECTION_FAILED(2002, "取消收藏失败！")
    ;


    private int errorCode;
    private String type;
    ErrorCode(int errorCode, String type) {
        this.errorCode = errorCode;
        this.type = type;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getType() {
        return type;
    }
}
