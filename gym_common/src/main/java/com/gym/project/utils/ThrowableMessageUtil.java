package com.gym.project.utils;

import java.lang.reflect.UndeclaredThrowableException;

public class ThrowableMessageUtil {

    public static String getMessage(Throwable e){
        String msg = null;
        if (e instanceof UndeclaredThrowableException){
            Throwable targetEx = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
            if (targetEx != null){
                msg = targetEx.getMessage();
            }
        } else {
            msg = e.getMessage();
        }
        return msg;
    }

}
