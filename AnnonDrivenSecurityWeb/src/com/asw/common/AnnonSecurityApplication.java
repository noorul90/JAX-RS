package com.asw.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.asw.resource.StockTradeResource;

public class AnnonSecurityApplication extends Application{
	private Set<Class<?>> classes;
	private Set<Object> singletons;
	
	public AnnonSecurityApplication() {
		classes = new HashSet<Class<?>>();
		singletons = new HashSet<Object>();
		
		//register for singleton
		//singletons.add(new StockTradeResource());
		
		//register for non-singleton
		classes.add(StockTradeResource.class);
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
