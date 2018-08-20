package com.byebye.kzj.webapi.aop;

import com.byebye.kzj.webapi.vo.ResponseCode;
import com.byebye.kzj.webapi.vo.ResponseVo;
import com.cloudyoung.ec.common.utils.LogUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    @Pointcut("execution(* com.cloudyoung.baic.webapi.controller..*.*(..))")
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
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Object object = null;
        //获取请求的sessionId
        String sessionId = request.getRequestedSessionId();
        try {
            //请求内容打印日志
            StringBuilder sb = new StringBuilder("");
            sb.append(" URL: ");
            sb.append(request.getRequestURL().toString());
            sb.append(" HTTP_METHOD: ");
            sb.append(request.getMethod());
            sb.append(" IP: ");
            sb.append(request.getRemoteAddr());
            logger.info("HTTP", sessionId, "HTTP request information", sb);
            //StopWatch 计时
            StopWatch clock = new StopWatch();
            //计时开始
            clock.start();
            //获取方法开始时间
            Date beginTime = new Date();
            //请求参数打印日志
            if(!"UpdateLoadScanImage".equals(methodName)){
                logger.info(methodName, sessionId, "", "", "接口传入参数:", args);
            }
            //被拦截方法的返回值
            object = pjp.proceed();
            //计时结束
            clock.stop();
            Date endTime = new Date();
            //返回数据打印日志
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info(methodName, sessionId, df.format(beginTime), df.format(endTime), "接口返回结果:", object);
            //打印接口执行时间
            logger.info(methodName, sessionId, "接口执行时间", clock.getTime());
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(methodName, sessionId, e);
            return ResponseVo.getInstanceForError(ResponseCode.ERROR.getCode(), "系统错误");
        }
    }


}
