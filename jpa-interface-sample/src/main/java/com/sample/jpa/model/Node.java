package com.sample.jpa.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Node<T> {

  private Long id;
  private T data;
  private int order;
  private Set<Node<T>> predecessors = new HashSet<>(0);
  private Set<Node<T>> successors = new HashSet<>(0);
  private Set<Edge<T>> edges = new HashSet<>(0);


  public Node(T data) {
    this.data = data;
  }

  
  public Node<T> addSuccessor(Node<T> successor) {
    if (null == this.successors)
      this.successors = new HashSet<>(0);
    if (null != successor) {
      this.successors.add(successor);
      addEdge(this, successor);
    }
    return this;
  }

  public Node<T> addSuccessors(Collection<Node<T>> successors) {
    if (null == this.successors)
      this.successors = new HashSet<>(0);
    this.successors.addAll(successors);
    this.addEdges(this, successors);
    return this;
  }


  /**
   * This is only to be used from test
   * 
   * @param successors
   * @return
   */
  @Deprecated
  public Node<T> addSuccessors(Node<T>... successors) {
    if (null == this.successors)
      this.successors = new HashSet<>(0);
    if (null != successors && successors.length > 0) {
      return addSuccessors(Arrays.<Node<T>>asList(successors));
    }
    return this;
  }

  public Node<T> addPredecessor(Node<T> predecessor) {
    if (null == this.predecessors) {
      this.predecessors = new HashSet<>(0);
    }
    if (null != predecessor) {
      this.predecessors.add(predecessor);
    }
    return this;
  }

  /**
   * This is only to be used from test
   * 
   * @param predecessors
   * @return
   */
  @Deprecated
  public Node<T> addPredecessors(Node<T>... predecessors) {
    if (null == this.predecessors) {
      this.predecessors = new HashSet<>(0);
    }
    return this.addPredecessor(Arrays.<Node<T>>asList(predecessors));
  }

  public Node<T> addPredecessor(Collection<Node<T>> predecessors) {
    if (null == this.predecessors) {
      this.predecessors = new HashSet<>(0);
    }
    if (null != predecessors && predecessors.size() > 0) {
      this.predecessors.addAll(predecessors);
    }

    return this;
  }

  public abstract Node<T> addEdge(Node<T> source, Node<T> target) ;

  public Node<T> addEdges(Node<T> source, Collection<Node<T>> targets) {
    if (null == getEdges()) {
      setEdges(new HashSet<>());
    }
    if (null != targets && targets.size() > 0) {
      for (Node<T> target : targets) {
        addEdge(source, target);
      }
    }
    return this;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[ ");
    if (data != null)
      builder.append(data);
    builder.append(" ]");
    return builder.toString();
  }



}
