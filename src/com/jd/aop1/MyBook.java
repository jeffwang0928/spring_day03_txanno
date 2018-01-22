package com.jd.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	
	@Before(value="execution(* com.jd.aop1.Book.*(..))")
	public void before1(){
		System.out.println("before1 .....");
	}
	
	@AfterReturning(value="execution(* com.jd.aop1.Book.*(..))")
	public void after_return1(){
		System.out.println("afterreturning .....");
	}
	
	@Around(value="execution(* com.jd.aop1.Book.*(..))")
	public void around1(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("around 1...");
		pjp.proceed();
		System.out.println("around 2...");
	}
}
