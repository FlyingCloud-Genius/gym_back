package com.gym.project.res.base;

import com.gym.project.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorData {

    private String code;

    private String msg;

    private String extra;

    private ErrorData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ErrorData buildErrorData(ErrorCodeEnum errorCodeEnum) {
        return new ErrorData(errorCodeEnum.getCode(), errorCodeEnum.getErrorMessage());
    }
}

