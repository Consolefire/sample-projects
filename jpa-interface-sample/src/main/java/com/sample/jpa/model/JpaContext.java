package com.sample.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="sample01")
public class JpaContext implements Context {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@Transient
	private Context parent;
	@Transient
	private Set<Context> childContexts = new HashSet<>();
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Context getParentContext() {
		return this.parent;
	}

	@Override
	public void setParentContext(Context context) {
		this.parent = context;
	}

	@Override
	public Set<Context> getChildContexts() {
		return this.childContexts;
	}

	@Override
	public void setChildContexts(Set<Context> contexts) {
		this.childContexts = contexts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JpaContext other = (JpaContext) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JpaContext [id=" + id + ", name=" + name + "]";
	}

	
	
}
