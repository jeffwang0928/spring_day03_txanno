package com.jd.jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo2 {

	@Test
	public void create(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		//创建sql语句
		String sql = "insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql,"Lucy","250");
		System.out.println(rows);
	}
	
	@Test
	public void update(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		//创建sql语句
		String sql = "update user set password=? where username=?";
		int rows = jdbcTemplate.update(sql,"111111","Lucy");
		System.out.println(rows);
	}
	
	
	@Test
	public void delete(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用jdbcTemplate对象里面的方法实现操作
		//创建sql语句
		String sql = "delete from user where username=?";
		int rows = jdbcTemplate.update(sql,"Lucy");
		System.out.println(rows);
	}
	
}
