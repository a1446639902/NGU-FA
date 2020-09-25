package com.yidu.permission.aspect;

import com.yidu.permission.pojo.Log;
import com.yidu.permission.service.LogService;
import com.yidu.util.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class NGULogAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @Resource
    LogService logService;

    private static Log log = new Log();

    @Around("within(com.yidu..*) && @annotation(myLog)")
    public Object around(ProceedingJoinPoint pjd,NGULog myLog) throws Throwable {
        log.setLogId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        log.setTime(format);
        //pjd.getSignature()得到织入点方法名
        String methodName = pjd.getSignature().getName();
        log.setMethod(methodName);


        //请求地址
        String uri = request.getRequestURI();
        log.setUri(uri);

        //IP
        String host = IPUtil.getIpAddr(request);
        log.setHost(host);
        //-------------上面是执行方法前
        //执行方法，获取返回参数
        Object result  = pjd.proceed();
        //-------------下面是执行方法后
        String message = myLog.message();
        log.setMessage(message);

        //操作人
        String userName = (String) session.getAttribute("userName");
        if (userName != null){
            log.setUserName(userName);
        }

        //录入数据库
        logService.insertLog(log);
        System.out.println(log);
        return result;
    }


}