package com.area.areademo.dao;

import com.area.areademo.entity.JdbcConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
@Configuration
//mapper的扫描
@MapperScan("com.area.areademo.dao")
public class DataSourceConfiguration {
    @Autowired
    private JdbcConfig jdbcConfig;
    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcConfig.getDriver());
        dataSource.setJdbcUrl(jdbcConfig.getUrl());
        dataSource.setUser(jdbcConfig.getUsername());
        dataSource.setPassword(jdbcConfig.getPassword());
        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
