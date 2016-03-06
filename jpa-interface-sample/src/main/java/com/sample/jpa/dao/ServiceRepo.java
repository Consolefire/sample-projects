/**
 * 
 */
package com.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.jpa.model.service.Service;

/**
 * @author sabuj.das
 *
 */
public interface ServiceRepo extends CrudRepository<Service, Long> {

}
