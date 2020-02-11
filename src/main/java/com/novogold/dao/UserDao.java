package com.novogold.dao;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.novogold.bean.User;


@Component
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//Properties props=new Properties();  
	
	
	public void getUser(String name) {
		/*String query="select * from user where user_name='"+viewUser.getUser_name()+"'";*/
		String query="select * from user where user_name='"+name+"'";
		
		User user = null;
		//jdbcTemplate.execute(query);
		user=(User) jdbcTemplate.queryForRowSet(query, User.class);
		System.out.println(user);
		//return user;
		
		
	}
	
}
