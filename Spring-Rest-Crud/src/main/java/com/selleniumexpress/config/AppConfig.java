package com.selleniumexpress.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com"})
public class AppConfig {
	
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dm=new DriverManagerDataSource("jdbc:mysql://127.0.0.1:3306/school?usesSSL=false", "root", "root"	);
		
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		return dm;
		
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		return new JdbcTemplate(getDataSource());
	}
	
	

}
