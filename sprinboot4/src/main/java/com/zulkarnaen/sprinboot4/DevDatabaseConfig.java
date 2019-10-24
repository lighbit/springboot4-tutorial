package com.zulkarnaen.sprinboot4;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("Database")
@Configuration
@ConfigurationProperties("spring.datasource")
public class DevDatabaseConfig implements DatabaseConfig {
	
	@Value("#{db['message']}")
	private String message;

	@Profile("dev")
	@Bean
	public DataSource createDataSourceDev() {
		System.out.println("Creating DEV database");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("URL: " + dataSource.getUrl() + " Username: " + dataSource.getUsername());
		/*
		 * Set MySQL specific properties for Development Environment
		 */
		return dataSource;
	}
	
	@Profile("prod")
	@Bean
	public DataSource createDataSourceProd() {
		System.out.println("Creating Production database");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*
		 * Set ORACLE specific properties for Production environment
		 */
		return dataSource;
	}

}