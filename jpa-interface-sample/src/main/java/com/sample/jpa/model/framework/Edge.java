package com.sample.jpa.model.framework;

import com.sample.jpa.model.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sabuj.das on 04/02/16.
 */
@Getter
@Setter
@NoArgsConstructor
public class Edge<T> extends BaseEntity{
  
  private Node<T> source;
  private Node<T> target;
   
  private int weight;
  
  public Edge(Node<T> source, Node<T> target) {
    this.source = source;
    this.target = target;
  }

  
}
