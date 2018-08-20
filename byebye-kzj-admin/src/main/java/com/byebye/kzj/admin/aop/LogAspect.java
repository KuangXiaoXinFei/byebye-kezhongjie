package com.byebye.kzj.admin.aop;

import com.byebye.kzj.common.utils.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常处理
 */
@Aspect
@Component
public class LogAspect {

    private LogUtils logger = LogUtils.build(this.getClass());

    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired(required = false)
    private HttpServletResponse response;


    @Pointcut("execution(* com.cloudyoung.baic.admin.controller..*.*(..))")
    private void controllerAspect() {
    }

    /**
     * 方法执行
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    /**
     * 方法执行
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Object object = null;
        try {
            //获取请求的sessionId
            String sessionId = request.getSession().getId();
            //请求参数打印日志
            writeLog(methodName, sessionId, "action入参开始", args);
            //获取方法开始时间
            Date beginTime = new Date();
            //被拦截方法的返回值
            object = pjp.proceed();
            Date endTime = new Date();
            //返回数据打印日志
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            writeLog(methodName, sessionId, df.format(beginTime), df.format(endTime), "action返回结果", object);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    private void writeLog(String method, String sessionId, String message, Object... args) {
        try {
            //请求参数打印日志
            Object[] targs = new Object[args.length];
            if (args != null && args.length > 0) {
                int idx = 0;
                for (Object obj : args) {
                    if (obj instanceof ServletRequest) {
                        continue;
                    }
                    if (obj instanceof ServletResponse) {
                        continue;
                    }
                    targs[idx] = obj;
                    idx++;
                }
            }
            logger.info(method, sessionId, message, targs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
