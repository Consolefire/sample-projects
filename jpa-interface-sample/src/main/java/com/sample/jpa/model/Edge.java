package com.sample.jpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sabuj.das on 04/02/16.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Edge<T> {
  
  
  private Node<T> source;
  
  
  private Node<T> target;
   
  private int weight;
  
  public Edge(Node<T> source, Node<T> target) {
    this.source = source;
    this.target = target;
  }

  
}
