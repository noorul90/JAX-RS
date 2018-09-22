package com.cch.common;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.cch.provider.contextresolver.JAXBContextResolver;
import com.cch.provider.reader.JAXBMessageBodyReader;
import com.cch.provider.writer.JAXBMessageBodyWriter;
import com.cch.resource.IdeaProvider;

@ApplicationPath("/rest")
public class IdeaApplication extends Application {
	
	private Set<Class<?>> classes;
	private Set<Object> singletons;
	
	public IdeaApplication(){
		classes = new HashSet<Class<?>>();
		singletons = new HashSet<Object>();
		
		//register for singletons
		singletons.add(new JAXBMessageBodyReader());
		singletons.add(new JAXBMessageBodyWriter());
		singletons.add(new JAXBContextResolver());
		
		//register for non-singletons
		classes.add(IdeaProvider.class);
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
