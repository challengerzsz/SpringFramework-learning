package com.ylxt.common;

public enum ResponseCode {

    SUCCESS(1, "SUCCESS"),
    ERROR(0, "ERROR"),
    DECLARED_SUBJECT(4, "HAS_DECLARED_SUBJECT"),
    SELECTED_SUBJECT(5, "HAS_SELECTED_SUBJECT"),
    NONE_REPORT(3, "NONE_REPORT"),
    NONE_PAPER(4, "NONE_PAPER"),
    NONE_EVALUATE(5, "NONE_EVALUATE");

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
