/**
 * 
 */
package com.sample.jpa.model.state;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sample.jpa.model.Composition;
import com.sample.jpa.model.service.Service;

import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table
@Access(AccessType.PROPERTY)
public class StateDiagram extends Composition<Service, State, StateNode> {

  @Setter
  private Long id;
  
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
    return this.id;
  }
  
  
  @Override
  @OneToMany(targetEntity=StateNode.class, cascade=CascadeType.ALL)
  public Set<StateNode> getNodes() {
    return super.getNodes();
  }

  @Override
  @OneToOne(targetEntity=Service.class, cascade=CascadeType.ALL)
  @JoinColumn(name="owner_node_id")
  public Service getOwner() {
    return super.getOwner();
  }

  @Override
  @OneToOne(targetEntity=StateNode.class, cascade=CascadeType.ALL)
  @JoinColumn(name="root_node_id")
  public StateNode getRoot() {
    return super.getRoot();
  }

  
  
}
