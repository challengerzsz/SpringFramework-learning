package pojo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {

    @Before("execution(* pojo.Performance.perform(..))")
    public void silenceCellPhone() {
        System.out.println("silence Cell Phone");
    }

    @Before("execution(* pojo.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking Seats");
    }

    @AfterReturning("execution(* pojo.Performance.perform(..))")
    public void applause() {
        System.out.println("Clap Clap Clap");
    }

    @AfterThrowing("execution(* pojo.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demand a refund");
    }
}
