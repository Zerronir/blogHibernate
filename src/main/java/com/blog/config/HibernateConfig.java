package com.blog.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.blog")
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        MysqlDataSource mds = new MysqlDataSource();
        mds.setUrl(env.getProperty("jdbc.url"));
        mds.setUser(env.getProperty("jdbc.user"));
        mds.setPassword(env.getProperty("jdbc.pass"));
        return mds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource mds) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.blog.entities");
        localContainerEntityManagerFactoryBean.setDataSource(mds);

        return localContainerEntityManagerFactoryBean;

    }

    @Bean
    public TransactionManager transactionManager (EntityManagerFactory entityManagerFactory, DataSource mds) {

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(mds);
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        return jpaTransactionManager;

    }

}
