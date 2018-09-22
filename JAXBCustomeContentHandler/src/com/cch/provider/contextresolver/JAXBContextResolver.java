package com.cch.provider.contextresolver;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.cch.dto.Reciept;
import com.cch.dto.Subscriber;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
	private JAXBContext jContext;

	public JAXBContextResolver() {
		try {
			jContext = JAXBContext.newInstance(Subscriber.class, Reciept.class);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
	}

	@Override
	public JAXBContext getContext(Class<?> classType) {
		if (classType.isAssignableFrom(Subscriber.class)
				|| classType.isAssignableFrom(Reciept.class)) {
			
			return jContext;
		}
		return null;
	}

}
