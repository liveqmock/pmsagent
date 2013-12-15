package com.yh.pmsagent.common;

import javax.sql.DataSource;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = { "com.yh.pmsagent" })
@EnableScheduling
public class SpringConfiguration {

	@Value("${datasource.cms.username}")
	private String jdbcName;

	@Value("${datasource.cms.password}")
	private String jdbcPassword;

	@Value("${datasource.cms.databaseUrl}")
	private String jdbcUrl;

	@Value("${datasource.cms.databaseDriver}")
	private String jdbcDriver;

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ClassPathResource[] resources = new ClassPathResource[] {
				new ClassPathResource("config.properties"),
				new ClassPathResource("jdbc.properties") };
		ppc.setLocations(resources);
		ppc.setIgnoreUnresolvablePlaceholders(false);
		return ppc;
	}

	@Bean(name = "datasource")
	public DataSource datasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(jdbcDriver);
		ds.setUrl(jdbcUrl);
		ds.setUsername(jdbcName);
		ds.setPassword(jdbcPassword);
		return ds;
	}
	@Bean(name="billingclient",destroyMethod="close")
	public CloseableHttpClient getHttpClient(){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		return httpclient;
	}
	@Bean(name="txManager")
	public  DataSourceTransactionManager getDataSourceTransactionManager(){
		DataSourceTransactionManager txManager= new DataSourceTransactionManager();
		txManager.setDataSource(datasource());
		return txManager;
	}
	 
}
