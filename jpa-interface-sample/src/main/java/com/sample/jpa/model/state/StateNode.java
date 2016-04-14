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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Propagation;

import com.sample.jpa.model.action.ActionComposition;
import com.sample.jpa.model.framework.Edge;
import com.sample.jpa.model.framework.Node;

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

  public enum Type {
    INITIAL, INTERNAL, TERMINAL
  }

  private Type type=Type.INTERNAL;

  /**
   * @param data
   */
  public StateNode(State data) {
    super(data);
  }

  @Setter
  private ActionComposition preActions;
  @Setter
  private ActionComposition postActions;
  private boolean propagationSupported=true;

  @OneToOne(mappedBy = "owner", targetEntity = ActionComposition.class, cascade = CascadeType.ALL)
  public ActionComposition getPreActions() {
    return this.preActions;
  }

  @OneToOne(mappedBy = "owner", targetEntity = ActionComposition.class, cascade = CascadeType.ALL)
  public ActionComposition getPostActions() {
    return this.postActions;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return super.getId();
  }

  @Override
  @OneToOne(targetEntity = State.class)
  public State getData() {
    return super.getData();
  }

  @Override
  @OneToMany(mappedBy = "source", targetEntity = StateTransition.class, cascade = CascadeType.ALL)
  public Set<Edge<State>> getEdges() {
    return super.getEdges();
  }


  @Override
  @Column(name = "seq")
  public int getOrder() {
    return super.getOrder();
  }

  @Override
  public Node<State> addEdge(Node<State> source, Node<State> target) {
    StateTransition transition = new StateTransition();
    transition.setSource(source);
    transition.setTarget(target);
    transition.setWeight(0);
    getEdges().add(transition);
    return this;
  }

  /**
   * @param stateTransition
   */
  public void addTransition(StateTransition stateTransition) {
    getEdges().add(stateTransition);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("StateNode [");
    if (null != getData()) {
      builder.append(getData()).append(": ");
    }
    if (type != null)
      builder.append("type=").append(type).append(", ");
    builder.append("propagationSupported=").append(propagationSupported).append("]");
    return builder.toString();
  }

  


}
