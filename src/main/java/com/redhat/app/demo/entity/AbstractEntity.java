package com.redhat.app.demo.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntity<T> implements GenericEntity<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -741167023767863387L;
	@Column(name = "name")
	private String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name=name;
	}

	

}
