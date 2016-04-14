/**
 * Created At 24-Mar-2016 Created By sabuj.das
 */
package com.sample.jpa.model.framework;

/**
 * @author sabuj.das
 *
 */
public abstract class DirectedAcyclicGraph<O, C, T extends Node<C>> extends DirectedGraph<O, C, T> {

  @Override
  protected Composition<O, C, T> addNode(T node, T predecessor) {
    if(null == node || null == predecessor){
      return super.addNode(node, predecessor);
    }
    return null;
  }

  @Override
  protected Composition<O, C, T> addNode(T node, T predecessor, T successor) {
    // TODO Auto-generated method stub
    return null;
  }

}
