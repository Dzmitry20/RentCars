package com.mycompany.beans;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApplicationBeans {


    @Bean
    public StringUtils getStringUtils() {
        return new StringUtils();
    }


    @Bean
    public NoOpPasswordEncoder noOpPasswordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("goods");
        cacheManager.setCaffeine(cacheProperties());
        return cacheManager;
    }

    @Bean
    public S3Client s3Client(AwsS3Config amazonConfiguration) {
        return S3Client
                .builder()
                .region(Region.of(amazonConfiguration.getRegion()))
                .credentialsProvider(() ->
                        AwsBasicCredentials.create(
                                amazonConfiguration.getAwsAccessKeyId(),
                                amazonConfiguration.getAwsSecretKey()
                        ))
                .build();
    }


    public Caffeine<Object, Object> cacheProperties() {
        return Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(50)
                .expireAfterAccess(20, TimeUnit.SECONDS)
                .weakKeys()
                .recordStats();
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//        //select * from users where user id = ?
//    }
//
//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
//        return new NamedParameterJdbcTemplate(dataSource);
//        // select * from users where user id = :userId
//    }
//
//    @Bean
//    public DataSource hikariDataSource(DatabaseProperties databaseProperties) {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//
//        hikariDataSource.setJdbcUrl(databaseProperties.getUrl());
//        hikariDataSource.setUsername(databaseProperties.getLogin());
//        hikariDataSource.setPassword(databaseProperties.getPassword());
//        hikariDataSource.setDriverClassName(databaseProperties.getDriverName());
//        hikariDataSource.setMaximumPoolSize(10);
//
//        return hikariDataSource;
//    }


//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//        // Fix Postgres JPA Error:
//        // Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
//        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);
//
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//        // Package contain entity classes
//        factoryBean.setPackagesToScan("com.mycompany");
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setHibernateProperties(getAdditionalProperties());
//        factoryBean.afterPropertiesSet();
//        //
//        SessionFactory sf = factoryBean.getObject();
//        System.out.println("## getSessionFactory: " + sf);
//        return sf;
//    }

    //Entity Manager

//    @Primary
//    @Autowired
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan("com.mycompany");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(getAdditionalProperties());
//
//        return em;
//    }
//
//    private Properties getAdditionalProperties() {
//        Properties properties = new Properties();
//
//        // See: application.properties
//        properties.put("hibernate.show_sql", "true");
//        properties.put("current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
//        return properties;
//    }

}
