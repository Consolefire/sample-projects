/**
 * 
 */
package com.sample.jpa.model.state;

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

import com.sample.jpa.model.Edge;
import com.sample.jpa.model.Node;
import com.sample.jpa.model.action.Action;
import com.sample.jpa.model.action.ActionTransition;

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
public class StateNode extends Node<State> {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
    return super.getId();
  }

  @Override
  @OneToOne(targetEntity=State.class)
  public State getData() {
    return super.getData();
  }

  @Override
  @OneToMany(mappedBy="source", targetEntity=StateTransition.class)
  public Set<Edge<State>> getEdges() {
    return super.getEdges();
  }
  
  /* (non-Javadoc)
   * @see com.sample.jpa.model.Node#getOrder()
   */
  @Override
  @Column(name="seq")
  public int getOrder() {
    // TODO Auto-generated method stub
    return super.getOrder();
  }
  
  @Override
  public Node<State> addEdge(Node<State> source, Node<State> target) {
    return null;
  }
}
