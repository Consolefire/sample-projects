/**
 * 
 */
package com.sample.jpa.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Getter
@Setter
public abstract class Composition<O, C, T extends Node<C>>  {

  public enum ContentType{
    STATE, ACTION, SERVICE, TASK
  }
  
  private O owner;
  private T root;
  private Set<T> nodes = new HashSet<>(0);
  
  public Composition<O, C, T> addNodes(T ... nodes ){
    if(null != nodes && nodes.length > 0){
      this.nodes.addAll(Arrays.<T>asList(nodes));
    }
    return this;
  }
  
  public Map<T, Set<T>> createAjdList(){
    Map<T, Set<T>> adjMap = new HashMap<>();
    if(null != nodes && nodes.size() > 0){
      for (T n : nodes) {
        adjMap.put(n, (Set<T>) n.getSuccessors());
      }
    }
    return adjMap;
  }
  
}
