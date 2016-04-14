/**
 * 
 */
package com.sample.jpa.model.action;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sample.jpa.model.framework.DirectedGraph;
import com.sample.jpa.model.state.StateNode;
import com.sample.jpa.model.state.StateTransition;

import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table
@Access(AccessType.PROPERTY)
public class TransitionActionComposition extends DirectedGraph<StateTransition, Action, ActionNode> {

  
  @Setter
  private Long id;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
    return this.id;
  }
  
  
  
  @Override
  @OneToMany(targetEntity=ActionNode.class)
  public Set<ActionNode> getNodes() {
    return super.getNodes();
  }

  @Override
  @OneToOne(targetEntity=StateNode.class)
  @JoinColumn(name="state_transition_id")
  public StateTransition getOwner() {
    return super.getOwner();
  }

  
  
  
  
}
