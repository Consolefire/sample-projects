/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.action.ActionNode;

/**
 * @author sabuj.das
 *
 */
public interface ActionNodeRepo extends CrudRepository<ActionNode, Long> {

}
