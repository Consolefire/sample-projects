package com.sample.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sample.jpa.model.Context;
import com.sample.jpa.model.JpaContext;

@Repository
public class ContextDaoImpl implements ContextDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Context create(Context context) {
		entityManager.persist(context);
		return context;
	}

	@Override
	public Context read(Long id) {
		Context context = entityManager.find(JpaContext.class, id);
		return context;
	}

	@Override
	public Context update(Context context) {
		return entityManager.merge(context);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.find(JpaContext.class, id));
	}

}
