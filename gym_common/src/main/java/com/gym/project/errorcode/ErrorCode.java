package com.gym.project.errorcode;

import lombok.Getter;
import lombok.Setter;

/**
 * 错误码对象
 *
 */
@Getter
@Setter
public class ErrorCode {

    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误码
     */
    private String code;

    public ErrorCode(String code, String msg) {
        this.code = code;
        this.message = msg;
    }
}

