package com.sample.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.jpa.dao.ContextDao;
import com.sample.jpa.model.Context;

@Service
public class ContextServiceImpl implements ContextService {

	@Autowired
	private ContextDao contextDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public Context create(Context context) {
		return contextDao.create(context);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public Context read(Long id) {
		return contextDao.read(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public Context update(Context context) {
		return contextDao.update(context);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void delete(Long id) {
		contextDao.delete(id);
	}

}
