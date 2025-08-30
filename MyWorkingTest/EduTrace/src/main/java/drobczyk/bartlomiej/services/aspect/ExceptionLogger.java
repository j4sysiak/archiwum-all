package drobczyk.bartlomiej.services.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLogger {

    @Pointcut("execution(* drobczyk.bartlomiej.controller..*(..))")
    private void checkEveryController() {
    }

    @AfterThrowing(pointcut = "checkEveryController()", throwing = "error")
    public void logError(JoinPoint joinPoint, Throwable error) {
        System.err.println(" \n  :: Error :: - Method" + joinPoint.getSignature() + " has thrown following error: "
                + error.toString() + "\n");
        error.printStackTrace();
    }
}