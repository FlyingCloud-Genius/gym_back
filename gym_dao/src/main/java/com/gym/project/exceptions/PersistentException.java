package com.gym.project.exceptions;

import com.gym.project.enums.ErrorCodeEnum;
import com.gym.project.errorcode.ErrorCode;
import lombok.Getter;

@Getter
public class PersistentException extends RuntimeException {

    private static final long serialVersionUID = 6643482569602370581L;

    /**
     * 错误信息
     */
    String message;

    /**
     * 错误码
     */
    String code;

    private ErrorCodeEnum codeEnum;

    public PersistentException(ErrorCodeEnum codeEnum) {
        code = codeEnum.getCode();
        this.codeEnum = codeEnum;
        String language = codeEnum.getLanguage();
        this.message = codeEnum.getErrorMessage(language);
    }

    public PersistentException(ErrorCodeEnum codeEnum, Throwable throwable) {
        super(codeEnum.toString(), throwable);
        code = codeEnum.getCode();
        this.codeEnum = codeEnum;
        String language = codeEnum.getLanguage();
        this.message = codeEnum.getErrorMessage(language);
    }

    public PersistentException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode.toString(), throwable);
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

    public PersistentException(ErrorCode errorCode) {
        super(errorCode.toString());
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

    public PersistentException(String errorMsg) {
        this.message = errorMsg;
    }

    /**
     * 获取异常消息文本
     */
    public String getMsg() {
        return message;
    }

    /**
     * 获取异常code
     */
    public String getCode() {
        return code;
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
