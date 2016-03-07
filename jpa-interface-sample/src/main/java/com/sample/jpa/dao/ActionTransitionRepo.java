/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.action.ActionTransition;

/**
 * @author sabuj.das
 *
 */
public interface ActionTransitionRepo extends CrudRepository<ActionTransition, Long> {

}
