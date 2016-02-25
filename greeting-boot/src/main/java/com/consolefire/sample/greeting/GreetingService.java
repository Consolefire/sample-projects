/**
 * 
 */
package com.consolefire.sample.greeting;

/**
 * @author sabuj.das
 *
 */
public interface GreetingService {

  Response sayHello();
  
  Response sayHello(String name);
  
}
