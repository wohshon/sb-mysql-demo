package com.redhat.app.demo.entity;
import java.io.Serializable;

public interface GenericEntity<T> extends Serializable {

	T getId();
	String getName();
	void setName(String name);
}
