package com.sample.jpa.dao;

import com.sample.jpa.model.Context;

public interface ContextDao {

	Context create(Context context);
	Context read(Long id);
	Context update(Context context);
	void delete(Long id);
	
}
