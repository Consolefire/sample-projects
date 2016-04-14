/**
 * 
 */
package com.sample.jpa.model.state;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sample.jpa.model.action.ActionComposition;
import com.sample.jpa.model.framework.Edge;
import com.sample.jpa.model.framework.Node;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Setter
@Entity
@Table
@NoArgsConstructor
@Access(AccessType.PROPERTY)
public class StateTransition extends Edge<State> {

  @Setter
  private Long id;
  

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
    return id;
  }
  
  @OneToOne
  private ActionComposition transitionActions;

  @Override
  @ManyToOne(targetEntity=StateNode.class, cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  public Node<State> getSource() {
    return super.getSource();
  }

  @Override
  @OneToOne(targetEntity=StateNode.class, cascade=CascadeType.ALL)
  @JoinColumn(name="target_node_id")
  public Node<State> getTarget() {
    return super.getTarget();
  }

  @Override
  public int getWeight() {
    return super.getWeight();
  }
  
  
  
}
