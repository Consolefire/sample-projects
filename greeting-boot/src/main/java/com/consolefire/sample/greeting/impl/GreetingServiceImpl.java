/**
 * 
 */
package com.consolefire.sample.greeting.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.consolefire.sample.greeting.GreetingService;
import com.consolefire.sample.greeting.Response;

/**
 * @author sabuj.das
 *
 */
@RestController
@RequestMapping(value="/greeting")
public class GreetingServiceImpl implements GreetingService{

  @Value( "${env}" ) 
  private String envName;
  
  @Value( "${env.service}" ) 
  private String serviceName;
  
  @Value( "${env.service.jdbc.url}" ) 
  private String jdbcUrl;
  @Value( "${env.service.jdbc.driverClassName}" ) 
  private String driverClassName;
  @Value( "${env.service.jdbc.username}" ) 
  private String username;
  @Value( "${env.service.jdbc.password}" ) 
  private String password;
  
  @Override
  @RequestMapping(method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public Response sayHello() {
    Response response = new Response();
    response.setMessage(String.format("Hello %s! from [ %s ] service.", "World", serviceName));
    response.getProperties().put("env", envName);
    response.getProperties().put("env.service", serviceName);
    response.getProperties().put("env.service.jdbc.url", jdbcUrl);
    response.getProperties().put("env.service.jdbc.username", username);
    response.getProperties().put("env.service.jdbc.driverClassName", driverClassName);
    response.getProperties().put("env.service.jdbc.password", password);
    return response;
  }
  
  @Override
  @RequestMapping(method=RequestMethod.GET, value="/{name}", produces={MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public Response sayHello(@PathVariable String name) {
    Response response = new Response();
    response.setMessage(String.format("Hello %s! from [ %s ] service.", name, serviceName));
    response.getProperties().put("env", envName);
    response.getProperties().put("env.service", serviceName);
    response.getProperties().put("env.service.jdbc.url", jdbcUrl);
    response.getProperties().put("env.service.jdbc.username", username);
    response.getProperties().put("env.service.jdbc.driverClassName", driverClassName);
    response.getProperties().put("env.service.jdbc.password", password);
    return response;
  }
}
