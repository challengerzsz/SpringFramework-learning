package com.ylxt.common;

public enum ResponseCode {

    SUCCESS(1, "SUCCESS"),
    ERROR(0, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),
    DECLARED_SUBJECT(4, "HAS_DECLARED_SUBJECT"),
    SELECTED_SUBJECT(5, "HAS_SELECTED_SUBJECT"),
    NONE_REPORT(3, "NONE_REPORT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
