/**
 * 
 */
package com.sample.jpa.model.action;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sample.jpa.model.Edge;
import com.sample.jpa.model.Node;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table
@Getter
@Setter
@Access(AccessType.PROPERTY)
public class ActionNode extends Node<Action> {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
    return super.getId();
  }

  
  @Override
  @OneToOne(targetEntity=Action.class)
  public Action getData() {
    return super.getData();
  }

  @Override
  @OneToMany(mappedBy="source", targetEntity=ActionTransition.class)
  public Set<Edge<Action>> getEdges() {
    return super.getEdges();
  }

  @Override
  @Column(name="seq")
  public int getOrder() {
    return super.getOrder();
  }

  @Override
  @Transient
  public Set<Node<Action>> getPredecessors() {
    return super.getPredecessors();
  }

  @Override
  @Transient
  public Set<Node<Action>> getSuccessors() {
    return super.getSuccessors();
  }

  
  @Override
  public Node<Action> addEdge(Node<Action> source, Node<Action> target) {
    ActionTransition actionTransition = new ActionTransition();
    getEdges().add(actionTransition);
    
    return this;
  }
}
