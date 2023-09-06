package ru.gloria_jeans.orders.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
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
        basePackages = "ru.gloria_jeans.onecdbmapper.dao",
        entityManagerFactoryRef = "onecEntityManager",
        transactionManagerRef = "onecTransactionManager"
)
public class OnecDatasourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource-onec-database")
    public DataSource onecDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager onecTransactionManager(
            @Qualifier("onecDataSource") DataSource onecDataSource
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(onecEntityManager(onecDataSource).getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean onecEntityManager(
            @Qualifier("onecDataSource") DataSource onecDataSource
    ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(onecDataSource);
        em.setPackagesToScan("ru.gloria_jeans.onecdbmapper.dao");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2016Dialect");
        properties.put("hibernate.ddl-auto", "none");
        properties.put("hibernate.default_schema", "dbo");
        properties.put("hibernate.format-sql", "true");
        properties.put("hibernate.generate_statistics", "false");
        properties.put("hibernate.physical_naming_strategy", "ru.gloria_jeans.onecdbmapper.NamingStrategy");
//        properties.put("hibernate.jdbc.batch_size", "5");
//        properties.put("hibernate.order_inserts", "true");
//        properties.put("hibernate.order_updates", "true");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public JdbcTemplate onecJdbcTemplate(
            @Qualifier("onecDataSource") DataSource onecDataSource
    ){
        return new JdbcTemplate(onecDataSource);
    }
}
