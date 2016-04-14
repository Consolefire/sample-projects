/**
 * Created At 24-Mar-2016 Created By sabuj.das
 */
package com.sample.jpa.model.framework;

/**
 * @author sabuj.das
 *
 */
public abstract class DirectedGraph<O, C, T extends Node<C>> extends Graph<O, C, T> {

  @Override
  protected Composition<O, C, T> addNode(T node, T predecessor) {
    if(null == node){
      return this;
    }
    if(null == predecessor){
      return addNode(node);
    }
    if(!getNodes().contains(predecessor)){
      return this;
    }
    predecessor.addSuccessor(node);
    getNodes().add(node);
    return this;
  }

  @Override
  protected Composition<O, C, T> addNode(T node, T predecessor, T successor) {
    if(null == successor){
      return addNode(node, predecessor);
    }
    if(null != node && null != predecessor){
      if(getNodes().contains(predecessor) && getNodes().contains(successor)){
        node.addPredecessor(predecessor);
        getNodes().add(node);
        node.addSuccessor(successor);
      }
    }
    return this;
  }

}
