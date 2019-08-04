package com.czh.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
//注解表示这是个切面
@Component
//表示这是个bean，由Spring管理
public class AOP {
    private static final Log logger = LogFactory.getLog(com.czh.aop.AOP.class);
    //该方式必须依靠log4j依赖包
    private long startTime;

    @Pointcut("execution(* com.czh.service.*.*(..))")
    //Pointcut表示式
    public void pointcut() {
        //Point签名
    }
    //声明一个切入点

    @Before("pointcut()")
    //声明该方法是一个前置通知:在目标方法开始之前执行
    public void before(JoinPoint joinPoint) {
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("----前置通知----");
        this.startTime = System.currentTimeMillis();
    }

    @After("pointcut()")
    //声明该方法是一个后置通知：在目标方法开始之后执行
    public void after(JoinPoint joinPoint) {
        logger.warn("----最终通知----");
        long endTime = System.currentTimeMillis();
        logger.warn("方法执行了" + (endTime - this.startTime) + "ms");
    }

    @Around(value = "execution(* com.czh.controller.*.*(..))||" +
            "execution(* com.czh.service.*.*(..))")
    //声明该方法是一个环绕通知
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.warn(proceedingJoinPoint.getSignature().getName());
        logger.warn("----环绕前置----");
        Object result = proceedingJoinPoint.proceed();
        logger.warn("----环绕后置----");
        return result;
    }

    @AfterReturning(value = "execution(* com.czh.service.*.*(..))", returning = "result")
    //声明该方法是一个返回结果通知
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("结果是" + result);
        logger.warn("----返回结果----");
    }

    @AfterThrowing(value = "execution(* com.czh.service.*.*(..))", throwing = "exp")
    //声明该方法是一个异常通知
    public void afterThrowing(JoinPoint joinPoint, Exception exp) {
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("异常消息：" + exp.getMessage());
        logger.warn("----异常通知----");
    }
}
