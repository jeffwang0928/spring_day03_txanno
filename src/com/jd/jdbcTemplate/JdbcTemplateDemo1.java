package com.jd.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

	@Test
	public void testCount(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//调用方法得到记录数
		String sql = "SELECT COUNT(*) FROM user";
		int count = jdbcTemplate.queryForObject(sql,Integer.class);
		System.out.println(count);
	}
	
	
	@Test
	public void testObject(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//调用方法得到对象
		String sql = "SELECT * FROM user WHERE username=?";
		
		//调用jdbcTemplate的方法实现，第二个参数是接口RowMapper，需要自己写类实现接口，自己做数据封装
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "lucy");
		System.out.println(user.toString());
	}
	
	
	
	
	
	@Test
	public void testList(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//调用方法得到对象
		String sql = "SELECT * FROM user;";
		
		//调用jdbcTemplate的方法实现，第二个参数是接口RowMapper，需要自己写类实现接口，自己做数据封装
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list.toString());
	}
} 



class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int n) throws SQLException {
		// 1 从结果集里面把数据得到
		String username = rs.getString("username");
		String password = rs.getString("password");
		//2把得到数据封装到对象里
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
}







