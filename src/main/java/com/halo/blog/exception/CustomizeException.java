package com.halo.blog.exception;

import java.lang.management.RuntimeMXBean;

/**
 * Created by halo on 2019/8/8.
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}

