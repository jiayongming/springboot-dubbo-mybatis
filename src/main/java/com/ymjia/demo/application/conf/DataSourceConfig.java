package com.ymjia.demo.application.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by jiayongming on 2018/3/29.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="application.datasource")
    public DataSource applicationDataSource(){
        return new DruidDataSource();
    }

}
