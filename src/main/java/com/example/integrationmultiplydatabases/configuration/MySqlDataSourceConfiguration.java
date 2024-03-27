package com.example.integrationmultiplydatabases.configuration;

import com.example.integrationmultiplydatabases.model.mysql.nhanvien;
//import com.example.integrationmultiplydatabases.model.mysql.phongban;
import com.example.integrationmultiplydatabases.model.sqlserver.NHANVIEN;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.integrationmultiplydatabases.repository.mysql",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef= "mysqlTransactionManager")
public class MySqlDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("app.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.mysql.configuration")
    public DataSource mysqlDataSource() {
        return mysqlDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mysqlDataSource())
                .packages("com.example.integrationmultiplydatabases.model.mysql")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager mysqlTransactionManager(
            final @Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(mysqlEntityManagerFactory.getObject()));
    }


}
