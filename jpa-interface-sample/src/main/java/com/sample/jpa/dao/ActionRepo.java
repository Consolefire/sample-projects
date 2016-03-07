/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.action.Action;

/**
 * @author sabuj.das
 *
 */
public interface ActionRepo extends CrudRepository<Action, String> {

}
