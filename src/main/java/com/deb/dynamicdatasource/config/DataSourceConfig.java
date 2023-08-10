package com.deb.dynamicdatasource.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.deb.dynamicdatasource.enums.DatabaseContext;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.deb.dynamicdatasource", entityManagerFactoryRef = "entityManager", transactionManagerRef = "multiTransactionManager")
public class DataSourceConfig {

	@Primary
	@Bean(name = "masterDataSource")
	@ConfigurationProperties("app.datasource.master")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "slave1DataSource")
	@ConfigurationProperties("app.datasource.slave1")
	public DataSource slave1DataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "slave2DataSource")
	@ConfigurationProperties("app.datasource.slave2")
	public DataSource slave2DataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "slave3DataSource")
	@ConfigurationProperties("app.datasource.slave3")
	public DataSource slave3DataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "slave0DataSource")
	@ConfigurationProperties("app.datasource.slave0")
	public DataSource slave0DataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "poste1DataSource")
	@ConfigurationProperties("app.datasource.poste1")
	public DataSource poste1DataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	@Bean(name = "dataSource")
	public DataSource dataSource() {

		Map<Object, Object> dataSourceMap = new HashMap<>();

		dataSourceMap.put(DatabaseContext.MASTER, masterDataSource());
		dataSourceMap.put(DatabaseContext.SLAVE1, slave1DataSource());
		dataSourceMap.put(DatabaseContext.SLAVE2, slave2DataSource());
		dataSourceMap.put(DatabaseContext.SLAVE3, slave3DataSource());
		dataSourceMap.put(DatabaseContext.SLAVE0, slave0DataSource());
		dataSourceMap.put(DatabaseContext.POSTE1, poste1DataSource());
		
		MultiRoutingDataSource routingDataSource = new MultiRoutingDataSource();
		//routingDataSource.setDefaultTargetDataSource(masterDataSource());
		//routingDataSource.setDefaultTargetDataSource(slave2DataSource());
		routingDataSource.setDefaultTargetDataSource(poste1DataSource());
		routingDataSource.setTargetDataSources(dataSourceMap);
		return routingDataSource;
	}

	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManager() throws PropertyVetoException {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("com.deb.dynamicdatasource.entity");
		entityManagerFactory.setJpaProperties(hibernateProperties());
		return entityManagerFactory;
	}

	@Bean(name = "multiTransactionManager")
	    public PlatformTransactionManager multiTransactionManager() throws PropertyVetoException {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManager().getObject());
	        return transactionManager;
	    }

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
}
