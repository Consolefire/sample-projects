package com.consolefire.orm.sample;

import com.consolefire.orm.config.OrmHelperPersistenceConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;

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
