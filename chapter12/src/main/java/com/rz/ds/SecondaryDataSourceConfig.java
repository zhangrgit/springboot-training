package com.rz.ds;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {"com.rz.repository.s" },//设置Repository所在位置
        transactionManagerRef = "transactionManagerSecondary",
        entityManagerFactoryRef = "entityManagerFactorySecondary")
public class SecondaryDataSourceConfig {

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;

	@Bean(name = "entityManagerSecondary")
	 public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecondary (builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactorySecondary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder build) {
		
		return build.dataSource(secondaryDataSource)
				    .properties(getVendorProperties())
	                .packages("com.rz.domain.s") //设置实体类所在位置
	                .persistenceUnit("secondaryPersistenceUnit")
	                .build();
	}

	@Autowired
	private JpaProperties jpaProperties;

	private Map<String, Object> getVendorProperties() {
		// 注意此处getHibernateProperties方法参数，1.x版本为DataSource
		return jpaProperties.getHibernateProperties(new HibernateSettings());
	}
	
	@Bean(name = "transactionManagerSecondary")
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }

}
