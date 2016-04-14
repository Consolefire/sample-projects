/**
 * 
 */
package com.sample.jpa.model.state;

import java.util.HashSet;
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

import com.sample.jpa.model.framework.DirectedGraph;
import com.sample.jpa.model.service.Service;

/**
 * @author sabuj.das
 *
 */
@Entity
@Table
@Access(AccessType.PROPERTY)
public class StateDiagram extends DirectedGraph<Service, State, StateNode> {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return super.getId();
  }


  @Override
  @OneToMany(targetEntity = StateNode.class, cascade = CascadeType.ALL)
  public Set<StateNode> getNodes() {
    return super.getNodes();
  }

  @Override
  @OneToOne(targetEntity = Service.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "owner_node_id")
  public Service getOwner() {
    return super.getOwner();
  }

  @Override
  @OneToOne(targetEntity = StateNode.class, cascade = CascadeType.ALL)
  public Set<StateNode> getRoots() {
    return super.getRoots();
  }

  
  
  public void addStateTransition(StateNode sourceNode, StateNode targetNode) {
    if(null == targetNode){
      return;
    }
    if(null == sourceNode){
      addNode(targetNode);
    }
    addNode(targetNode, sourceNode);
    StateTransition stateTransition = new StateTransition();
    stateTransition.setSource(sourceNode);
    stateTransition.setTarget(targetNode);
    sourceNode.addTransition(stateTransition);
  }

  public Set<StateNode> getStateNodesOf(StateNode.Type type){
    Set<StateNode> nodes = new HashSet<>();
    for (StateNode sn : getNodes()) {
      if(type.equals(sn.getType())){
        nodes.add(sn);
      }
    }
    return nodes;
  }


  public StateDiagram copy(){
    StateDiagram diagram = new StateDiagram();
    
    return diagram;
  }
  
  /**
   * @param diagram
   */
  public void copy(StateDiagram diagram) {
    
  }
  
  
}
