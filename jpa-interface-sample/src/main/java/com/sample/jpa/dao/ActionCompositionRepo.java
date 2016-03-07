/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.action.ActionComposition;

/**
 * @author sabuj.das
 *
 */
public interface ActionCompositionRepo extends CrudRepository<ActionComposition, Long> {

}
