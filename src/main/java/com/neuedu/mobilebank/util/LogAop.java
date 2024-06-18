package com.neuedu.mobilebank.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAop {
    //日志门面接口
    private static final Logger logger= LoggerFactory.getLogger(LogAop.class);

    //切点方法
    @Pointcut("execution(* com.neuedu.mobilebank.controller.*.*(..))")
    private void start(){

    }


    //异常抛出通知方法，一旦控制类方法抛出异常，对应方法即可执行
    @AfterThrowing(pointcut = "start()", throwing = "ex")
    public void exceptionMethod(JoinPoint jp, Exception ex){
        logger.debug("异常信息", ex);
    }


}
