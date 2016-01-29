package com.sample.jpa.model;

import java.util.Set;


public interface Context {

	Long getId();
	
	void setId(Long id);
	
	String getName();
	
	void setName(String name);
	
	
	Context getParentContext();
	
	void setParentContext(Context context);
	
	Set<Context> getChildContexts();
	
	void setChildContexts(Set<Context> contexts);
	
}
