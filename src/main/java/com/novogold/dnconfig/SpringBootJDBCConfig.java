package com.novogold.dnconfig;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringBootJDBCConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/novogold");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	/*
	@ConditionalOnMissingBean
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
	}*/
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate namedParameterJdbcTemplate=new JdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
	}
	
	
	
}
