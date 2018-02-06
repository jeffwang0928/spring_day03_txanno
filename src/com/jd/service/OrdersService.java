package com.jd.service;

import org.springframework.transaction.annotation.Transactional;

import com.jd.dao.OrdersDao;

@Transactional
public class OrdersService {

	private OrdersDao ordersDao;
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	public void accountMoney(){
		//System.out.println("accountMoney start...");
		ordersDao.lessMoney();
		
		//故障引起中断
		int a = 10/0;
		
		ordersDao.moreMoney();
	}
}
