package io.pragra.learning.july2024aop.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class LoggingAdvise {
    Logger logger = LoggerFactory.getLogger(LoggingAdvise.class);

    //pointcut
    @Pointcut(value = "execution(* io.pragra.learning.july2024aop.*.*.*(..) )")
    public void loggingPointCut(){
        //Cron job:  * * * 2 *
    }


    @Around("loggingPointCut()")
    public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        String argsAsString = mapper.writeValueAsString(args);
        logger.info(Instant.now() + " Class: " + className + " Method: " + methodName +" started exection with parameter " + argsAsString);
        Object object = pjp.proceed();
        String returnData = mapper.writeValueAsString(object);
        logger.info(Instant.now() + " Class: " + className + " Method: " + methodName +" finished exection with return data: " + returnData);
        return object;
    }
}
