package org.bootapp.aop;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class ForTestAspect {
	private static final Logger logger = LoggerFactory.getLogger(ForTestAspect.class);
	
	@Pointcut("execution(public * org.bootapp.controller.UserInfoController.*(..))")
	private void pointCut(){}
	/*u will see the error info in the console, when you start a request to /user/*/
	@Before("pointCut()")
    public void beforeInit() throws Throwable {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
        logger.error("before in voke controller method " + request.getMethod() + " " + request.getRemoteAddr());
    }
    @After("pointCut()")
    public void afterInit() throws Throwable {
    	logger.error("after in voke controller method ");
    }
}
