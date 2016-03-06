/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.state.StateNode;

/**
 * @author sabuj.das
 *
 */
public interface StateNodeRepo extends CrudRepository<StateNode, Long> {

}
