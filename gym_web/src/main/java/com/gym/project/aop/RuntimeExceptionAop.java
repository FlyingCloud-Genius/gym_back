package com.gym.project.aop;

import com.alibaba.fastjson.JSON;
import com.gym.project.enums.ErrorCodeEnum;
import com.gym.project.exceptions.BusinessException;
import com.gym.project.exceptions.PersistentException;
import com.gym.project.res.base.CommonResponse;
import com.gym.project.utils.StringManager;
import com.gym.project.utils.ThrowableMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
@Slf4j
public class RuntimeExceptionAop {

    @Around(value = "execution(public * com.gym.project.controller.*(..))", argNames = "proceedingJoinPoint")
    public Object exceptionAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            log.info("exceptionAround处理开始，请求参数：" + JSON.toJSONString(proceedingJoinPoint.getArgs()));
            try {
                result = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                log.error("异常处理："+ ThrowableMessageUtil.getMessage(throwable));
                result = dealExceptionResult(throwable, proceedingJoinPoint);
            }
            log.info("exceptionAround处理结束，响应参数：" + JSON.toJSONString(result));
        } catch (Exception e) {
            log.error("处理AppRuntimeExceptionAop时，出现异常", e);
        }
        return result;
    }

    private Object dealExceptionResult(Throwable throwable, ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        Signature signature = proceedingJoinPoint.getSignature();
        if (throwable instanceof BusinessException) {
            BusinessException businessException = (BusinessException) throwable;
            result = buildResult(signature, businessException.getCode(), businessException.getMessage());
        } else if (throwable instanceof PersistentException) {
            PersistentException persistentException = (PersistentException) throwable;
            result = buildResult(signature, persistentException.getCode(), persistentException.getMsg());
        } else {
            ErrorCodeEnum defaultErrorCodeEnum = ErrorCodeEnum.ERROR_DEFAULT;
            result = buildResult(signature, defaultErrorCodeEnum.getCode(), defaultErrorCodeEnum.getErrorMessage());
        }
        return result;
    }

    /**
     * 异常时，构建BaseResult返回对象
     *
     * @param signature
     * @param errorMessage
     * @return ResponseBean
     */
    private Object buildResult(Signature signature, String errorCode, String errorMessage) {
        Class returnType = ((MethodSignature) signature).getReturnType();
        Object object = null;
        try {
            object = returnType.newInstance();
        } catch (InstantiationException e) {
            log.error("buildResult's InstantiationException", ExceptionUtils.getStackTrace(e));
        } catch (IllegalAccessException e) {
            log.error("buildResult's IllegalAccessException", ExceptionUtils.getStackTrace(e));
        }

        if (object instanceof CommonResponse) {
            object = CommonResponse.buildFailRes(ErrorCodeEnum.getEnumByCode(errorCode));
        }
        return object;
    }
}
