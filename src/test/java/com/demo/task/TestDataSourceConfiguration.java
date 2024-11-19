package com.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@TestConfiguration
public class TestDataSourceConfiguration
{

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource()
    {
        var dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(env.getProperty("TEST_POSTGRES_DB"));
        dataSourceBuilder.username(env.getProperty("TEST_POSTGRES_USER"));
        dataSourceBuilder.password(env.getProperty("TEST_POSTGRES_PASSWORD"));
        return dataSourceBuilder.build();
    }

}

