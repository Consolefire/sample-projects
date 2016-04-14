/**
 * Created At 24-Mar-2016 Created By sabuj.das
 */
package com.sample.jpa.model.framework;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

/**
 * @author sabuj.das
 *
 */
@Getter
public abstract class Graph<O, C, T extends Node<C>> extends Composition<O, C, T> {

  /**
   * The root node of the composition. This root only needs to
   */
  private Set<T> roots;
  
  @Override
  protected Composition<O, C, T> addNode(T node) {
    if (null == node) {
      return this;
    }
    if (null == roots) {
      roots = new HashSet<>();
    }
    roots.add(node);
    getNodes().add(node);
    return this;
  }

  public void addRoot(T node){
    if(null == node){
      return;
    }
    if(null == roots){
      roots = new HashSet<>();
    }
    roots.add(node);
  }
}
