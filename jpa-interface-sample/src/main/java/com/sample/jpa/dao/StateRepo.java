/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.state.State;

/**
 * @author sabuj.das
 *
 */
public interface StateRepo extends CrudRepository<State, String> {

}
