package com.devhub.common.response;

public class Meta {
    public int errorCode;
    public String errorDesc;

    public Meta(int errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public Meta() {
    }
}
