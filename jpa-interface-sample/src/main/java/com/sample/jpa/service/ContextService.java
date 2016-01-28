package com.sample.jpa.service;

import com.sample.jpa.model.Context;

public interface ContextService {

	Context create(Context context);
	Context read(Long id);
	Context update(Context context);
	void delete(Long id);
	
}
