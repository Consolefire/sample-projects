/**
 * 
 */
package com.sample.jpa.model.state;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sample.jpa.model.Edge;
import com.sample.jpa.model.Node;
import com.sample.jpa.model.action.ActionComposition;

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

  @Setter
  private ActionComposition preActions;
  @Setter
  private ActionComposition postActions;
  
  @OneToOne(mappedBy="owner", targetEntity=ActionComposition.class, cascade=CascadeType.ALL)
  public ActionComposition getPreActions(){
    return this.preActions;
  }
  
  @OneToOne(mappedBy="owner", targetEntity=ActionComposition.class, cascade=CascadeType.ALL)
  public ActionComposition getPostActions(){
    return this.postActions;
  }
  
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
  @OneToMany(mappedBy="source", targetEntity=StateTransition.class, cascade=CascadeType.ALL)
  public Set<Edge<State>> getEdges() {
    return super.getEdges();
  }
  
  
  @Override
  @Column(name="seq")
  public int getOrder() {
    return super.getOrder();
  }
  
  @Override
  public Node<State> addEdge(Node<State> source, Node<State> target) {
    StateTransition transition = new StateTransition();
    transition.setSource(source);
    transition.setTarget(target);
    transition.setWeight(1);
    getEdges().add(transition);
    return this;
  }
}
