/**
 * 
 */
package com.sample.jpa.model.framework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sample.jpa.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Composition is to define a structure of Nodes with relationship.
 * 
 * @author sabuj.das
 *
 */
@Getter
@Setter
public abstract class Composition<O, C, T extends Node<C>> extends BaseEntity {

  /**
   * The owner of the composition
   */
  private O owner;

  /**
   * The nodes those are part of this composition
   */
  private Set<T> nodes = new HashSet<>(0);


  public Composition<O, C, T> addNodes(T... nodes) {
    if (null != nodes && nodes.length > 0) {
      this.nodes.addAll(Arrays.<T>asList(nodes));
    }
    return this;
  }

  public Map<T, Set<T>> createAjdList() {
    Map<T, Set<T>> adjMap = new HashMap<>();
    if (null != nodes && nodes.size() > 0) {
      for (T n : nodes) {
        adjMap.put(n, (Set<T>) n.getSuccessors());
      }
    }
    return adjMap;
  }

  /**
   * Adds a node without any predecessor and successor. Default this node becomes root.
   * 
   * @param node
   * @return
   */
  protected abstract Composition<O, C, T> addNode(T node);

  /**
   * Adding a new node after the predecessor. It creates an Edge from the predecessor to this node.
   * @param node
   * @param predecessor
   * @return
   */
  protected abstract Composition<O, C, T> addNode(T node, T predecessor);

  /**
   * Insert a node between the predecessor and the successor.
   * @param node
   * @param predecessor
   * @param successor
   * @return
   */
  protected abstract Composition<O, C, T> addNode(T node, T predecessor, T successor);

}
