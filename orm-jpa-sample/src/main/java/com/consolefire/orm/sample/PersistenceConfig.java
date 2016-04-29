package com.consolefire.orm.sample;

import com.consolefire.orm.config.AuditPropertiesProvider;
import com.consolefire.orm.config.OrmHelperPersistenceConfig;
import com.consolefire.orm.helper.DataSourceTypeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabuj.das on 14/04/16.
 */
@Configuration
public class PersistenceConfig {

    @Value("${persistence.driverClass}")
    private String driverClass;
    @Value("${persistence.master.url}")
    private String masterUrl;
    @Value("${persistence.master.userName}")
    private String masterUser;
    @Value("${persistence.master.password}")
    private String masterPass;
    @Value("${persistence.slave.url}")
    private String slaveUrl;
    @Value("${persistence.slave.userName}")
    private String slaveUser;
    @Value("${persistence.slave.password}")
    private String slavePass;


    @Bean(name = "ormHelper.entityPackagesToScan")
    public List<String> entityPackagesToScan(){
        List<String> list = new ArrayList<>();
        list.add("com.consolefire.orm.sample.entity");
        return list;
    }

    @Bean(name = "ormHelper.masterDataSource")
    public DataSource masterDS(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(masterUrl);
        dataSource.setUsername(masterUser);
        dataSource.setPassword(masterPass);
        return dataSource;
    }

    @Bean(name = "ormHelper.slaveDataSource")
    public DataSource slaveDS(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(slaveUrl);
        dataSource.setUsername(slaveUser);
        dataSource.setPassword(slavePass);
        return dataSource;
    }

    @Bean(name = "ormHelper.defaultDataSourceType")
    public DataSourceTypeContext.DataSourceType defaultDsType(){
        return DataSourceTypeContext.DataSourceType.MASTER;
    }

}
