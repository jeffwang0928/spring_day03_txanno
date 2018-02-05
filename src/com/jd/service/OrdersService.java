package com.jd.service;

import com.jd.dao.OrdersDao;

public class OrdersService {

	private OrdersDao ordersDao;
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	public void accountMoney(){
		ordersDao.lessMoney();
		
		ordersDao.moreMoney();
	}
}
