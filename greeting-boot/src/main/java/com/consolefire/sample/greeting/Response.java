/**
 * 
 */
package com.consolefire.sample.greeting;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author sabuj.das
 *
 */
public class Response {

  private final Map<String, String> properties = new TreeMap<>();
  private String message;
  
  public Map<String, String> getProperties(){
    return this.properties;
  }
  
  public String getMessage(){
    return this.message;
  }
  
  public void setMessage(String message){
    this.message = message;
  }
}
