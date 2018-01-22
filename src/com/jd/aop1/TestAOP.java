package com.jd.aop1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	
	@Test
	public void testAop(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop1.xml");
		Book book = (Book) ac.getBean("book");
		book.add();
	}
}
