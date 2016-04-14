/**
 * 
 */
package com.sample.jpa.model.framework;

/**
 * @author sabuj.das
 *
 */
public interface NodeSupport<T, N extends Node<T>> {

  N createNode();
  
  public default N createNode(T t){
    return null;
  }
  
}
