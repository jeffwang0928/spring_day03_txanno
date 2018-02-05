package com.jd.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	
	@Test
	public void testOrders(){
		ApplicationContext aContext = new ClassPathXmlApplicationContext("bean1.xml");
		OrdersService service = (OrdersService) aContext.getBean("ordersService");
		//µ÷ÓÃ
		service.accountMoney();
	}
}
