package com.consolefire.sample.greeting;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration("com.consolefire.sample.greeting")
@EnableAutoConfiguration
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean
  public static PropertyPlaceholderConfigurer properties() {
    PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
    FileSystemResource resources = new FileSystemResource("/etc/config/application.properties");
    ppc.setLocations(resources);
    ppc.setIgnoreUnresolvablePlaceholders(true);
    return ppc;
  }

}
