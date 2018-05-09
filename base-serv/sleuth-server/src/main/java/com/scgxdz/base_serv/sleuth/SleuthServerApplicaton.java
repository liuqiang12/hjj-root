package com.scgxdz.base_serv.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class SleuthServerApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApplicaton.class, args);
    }
    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }
    /*@Bean
    public MySQLStatementInterceptorManagementBean mySQLStatementInterceptorManagementBean() {
        return new MySQLStatementInterceptorManagementBean(brave().clientTracer());
    }*/
}
