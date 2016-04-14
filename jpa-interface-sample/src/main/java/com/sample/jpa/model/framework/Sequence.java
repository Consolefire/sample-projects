/**
 * 
 */
package com.sample.jpa.model.framework;

import lombok.Getter;
import lombok.Setter;

/**
 * Sequence is also a composition. It makes sure the content C is in Sequence.
 * 
 * @author sabuj.das
 *
 */
@Getter
@Setter
public abstract class Sequence<O, C, T extends Node<C>> extends Composition<O, C, T> {

  private T root;
  
  /**
   * Adds the current node to the end of the sequence
   * @param contentNode
   */
  public void addToSequence(T contentNode) {
    addNode(contentNode);
  }

  @Override
  protected Composition<O, C, T> addNode(T contentNode) {
    if(null == contentNode){
      return this;
    }
    if (null == getRoot()) {
      setRoot(contentNode);
      getNodes().add(contentNode);
      return this;
    }
    Node<C> root = getRoot();
    while (null != root.getSuccessors() && root.getSuccessors().size() > 0) {
      root = root.getSuccessors().iterator().next();
    }
    root.addSuccessor(contentNode);
    contentNode.addPredecessor(root);
    getNodes().add(contentNode);
    return this;
  }

  @Override
  protected Composition<O, C, T> addNode(T node, T predecessor) {
    return this;
  }

  @Override
  public Composition<O, C, T> addNode(T node, T predecessor, T successor) {
    return this;
  }

  


}
