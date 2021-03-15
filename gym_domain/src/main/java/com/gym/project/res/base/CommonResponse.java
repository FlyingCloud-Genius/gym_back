package com.gym.project.res.base;

import com.gym.project.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 3387219978615421196L;
    private static final Integer SUCCESS_FLAG = 1;
    private static final Integer FAIL_FLAG = 0;

    /**
     * 成功或失败
     * resultCode==0：失败
     * resultCode==1：成功
     */
    private Integer resultCode;

    /**
     * 返回的结果数据
     */
    private T resultData;

    /**
     * 异常时响应消息
     */
    private ErrorData errorData;


    public CommonResponse() {

    }

    public static <T> CommonResponse<T> buildSuccessRes(T resultData) {
        CommonResponse<T> res = new CommonResponse<>();
        res.setResultCode(SUCCESS_FLAG);
        res.setResultData(resultData);
        res.setErrorData(null);
        return res;
    }

    public static <T> CommonResponse<T> buildFailRes(ErrorCodeEnum errorCodeEnum) {
        CommonResponse<T> res = new CommonResponse<>();
        res.setResultCode(FAIL_FLAG);
        res.setErrorData(ErrorData.buildErrorData(errorCodeEnum));
        res.setResultData(null);
        return res;
    }

    public static <T> CommonResponse<T> buildFailRes(T resultData, ErrorCodeEnum errorCodeEnum) {
        CommonResponse<T> res = new CommonResponse<>();
        res.setResultCode(FAIL_FLAG);
        res.setErrorData(ErrorData.buildErrorData(errorCodeEnum));
        res.setResultData(resultData);
        return res;
    }

    public boolean isSuccess() {
        return resultCode == null ? false : resultCode.equals(SUCCESS_FLAG);
    }

}