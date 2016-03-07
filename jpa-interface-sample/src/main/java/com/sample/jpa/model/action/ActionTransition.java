/**
 * 
 */
package com.sample.jpa.model.action;

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

import com.sample.jpa.model.Edge;
import com.sample.jpa.model.Node;

import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table
@Access(AccessType.PROPERTY)
public class ActionTransition extends Edge<Action> {

  @Setter
  private Long id;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
    return id;
  }
  
  @Override
  @ManyToOne(targetEntity=ActionNode.class, cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  public Node<Action> getSource() {
    return super.getSource();
  }

  @Override
  @OneToOne(targetEntity=ActionNode.class, cascade=CascadeType.ALL)
  @JoinColumn(name="target_node_id")
  public Node<Action> getTarget() {
    return super.getTarget();
  }

  @Override
  public int getWeight() {
    return super.getWeight();
  }
  
  
}
