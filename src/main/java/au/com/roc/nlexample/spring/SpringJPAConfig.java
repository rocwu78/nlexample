package au.com.roc.nlexample.spring;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration for Spring Persistence
 * 
 * @author Roc 29/04/2016
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("au.com.roc.nlexample.dao")
public class SpringJPAConfig {

	@Bean
	public DataSource dataSource() {
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setName("nlexample");
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) 
			.addScript("db/initdb.sql")
			.build();

		return db;
	}

	@Autowired
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("au.com.roc.nlexample");
		factoryBean.setJpaVendorAdapter(adapter);
		return factoryBean;
	}

	@Autowired
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
