package com.consolefire.orm.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by sabuj.das on 14/04/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.consolefire.orm.sample", "com.consolefire.orm.helper"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TestConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
