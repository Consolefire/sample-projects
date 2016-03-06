/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.state.StateTransition;

/**
 * @author sabuj.das
 *
 */
public interface StateTransitionRepo extends CrudRepository<StateTransition, Long> {

}
