package com.gym.project.enums;

import com.gym.project.errorcode.ErrorCode;
import com.gym.project.utils.StringManager;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public enum ErrorCodeEnum {

    SUCCESS("000000"),
    ERROR_DEFAULT("999999"),
    ERROR_PERSISTENT("sys100001"),
    ERROR_BUSINESS("bus100001"),
    ;

    private String code;

    /**
     * 语言
     */
    private String language;


    private ErrorCodeEnum(String code) {
        this.code = code;
        this.language = "th_TH";
    }

    private ErrorCodeEnum(String code, String language) {
        this.code = code;
        this.language = language;
    }

    public String getErrorMessage() {
        return StringManager.getInstance().getString(language, String.valueOf(this.getCode()));
    }

    public String getErrorMessage(Object... args) {
        return StringManager.getInstance().getString(language, String.valueOf(this.getCode()), args);
    }

    public String getLanguageErrorMessage(String language) {
        return StringManager.getInstance().getString(language, String.valueOf(this.getCode()));
    }

    public String getLanguageErrorMessage(String language, Object... args) {
        return StringManager.getInstance().getString(language, String.valueOf(this.getCode()), args);
    }

    public ErrorCode getErrorCode(String language) {
        return new ErrorCode(this.getCode(), getLanguageErrorMessage(language));
    }

    public ErrorCode getErrorCode(String language, Object... args) {
        return new ErrorCode(this.getCode(), getLanguageErrorMessage(language, args));
    }

    public ErrorCode getErrorCodeByException(String errMsg, Throwable throwable) {
        return getErrorCodeByException(language, errMsg, throwable);
    }

    public ErrorCode getErrorCodeByException(String language, String errMsg, Throwable throwable) {
        logger.error(errMsg, throwable);
        return getErrorCode(language);
    }

    @Override
    public String toString() {
        return code + "";
    }

    private static Logger logger = LoggerFactory.getLogger(ErrorCodeEnum.class);

    public static ErrorCodeEnum getEnumByCode(String code) {
        ErrorCodeEnum[] values = ErrorCodeEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getCode().equals(code)) {
                return values[i];
            }
        }
        logger.error("occur a unusual code,{}", code);
        return ErrorCodeEnum.ERROR_DEFAULT;
    }



}
