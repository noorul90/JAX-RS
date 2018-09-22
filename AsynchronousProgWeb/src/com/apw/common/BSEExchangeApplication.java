package com.apw.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.apw.resource.BSEExchangeResource;

public class BSEExchangeApplication extends Application {
	private Set<Class<?>> classes;
	private Set<Object> singletons;
	
	public BSEExchangeApplication() {
		classes = new HashSet<Class<?>>();
		singletons = new HashSet<Object>();
		
		singletons.add(new BSEExchangeResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
}
