package com.sw.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.sw.resource.StockTrade;

public class SecurityApplication extends Application {
	private Set<Class<?>> classes;
	private Set<Object> singletons;
	
	public SecurityApplication() {
		classes = new HashSet<Class<?>>();
		singletons = new HashSet<Object>();
		
		singletons.add(new StockTrade());
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
