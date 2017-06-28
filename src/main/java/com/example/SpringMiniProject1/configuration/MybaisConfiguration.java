package com.example.SpringMiniProject1.configuration;





import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("com.example.SpringMiniProject1.repositories")
public class MybaisConfiguration {
	
	private DataSource dataSource;
	
	@Autowired
	public MybaisConfiguration(DataSource dataSource)
	{
		this.dataSource=dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager()
	{
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean()
	{
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean;
	}
	
}
