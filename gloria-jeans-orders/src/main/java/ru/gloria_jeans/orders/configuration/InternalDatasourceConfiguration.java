package ru.gloria_jeans.orders.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
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

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "ru.gloria_jeans.orders.dao",
        entityManagerFactoryRef = "internalServiceEntityManager",
        transactionManagerRef = "internalServiceTransactionManager"
)
public class InternalDatasourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource-internal-database")
    public DataSource internalServiceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager internalServiceTransactionManager(
            @Qualifier("internalServiceDataSource") DataSource internalServiceDataSource
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(internalServiceEntityManager(internalServiceDataSource).getObject());
        return transactionManager;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean internalServiceEntityManager(
            @Qualifier("internalServiceDataSource") DataSource internalServiceDataSource
    ) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(internalServiceDataSource);
//        em.setPackagesToScan("ru.gloria_jeans.orders.dao");
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////        vendorAdapter.setShowSql(true);
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2016Dialect");
//        properties.put("hibernate.jdbc.lob.non_contextual_creation", "true");
//        em.setJpaPropertyMap(properties);
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(internalServiceDataSource);
        em.setPackagesToScan("ru.gloria_jeans.orders.dao");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2016Dialect");
        properties.put("hibernate.ddl-auto", "none");
        properties.put("hibernate.default_schema", "dbo");
        properties.put("hibernate.format-sql", "false");
        properties.put("hibernate.generate_statistics", "false");
        em.setJpaPropertyMap(properties);
        return em;
    }
}
