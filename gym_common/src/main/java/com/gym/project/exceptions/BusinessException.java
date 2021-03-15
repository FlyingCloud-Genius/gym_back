package com.gym.project.exceptions;

import com.gym.project.enums.ErrorCodeEnum;
import com.gym.project.errorcode.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 6643482569602370581L;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误码
     */
    private String code;

    private ErrorCodeEnum codeEnum;

    public BusinessException(ErrorCodeEnum codeEnum) {
        code = codeEnum.getCode();
        this.message = codeEnum.getErrorMessage();
        this.codeEnum = codeEnum;
    }

    public BusinessException(ErrorCodeEnum codeEnum, String... args) {
        code = codeEnum.getCode();
        String language = codeEnum.getLanguage();
        this.message = codeEnum.getLanguageErrorMessage(language, args);
        this.codeEnum = codeEnum;
    }

    public BusinessException(ErrorCodeEnum codeEnum, Throwable throwable) {
        super(codeEnum.toString(), throwable);
        code = codeEnum.getCode();
        String language = codeEnum.getLanguage();
        this.message = codeEnum.getLanguageErrorMessage(language);
        this.codeEnum = codeEnum;
    }

    public BusinessException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode.toString(), throwable);
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.toString());
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }


}
