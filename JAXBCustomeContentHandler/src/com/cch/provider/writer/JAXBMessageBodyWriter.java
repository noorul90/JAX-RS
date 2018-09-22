package com.cch.provider.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class JAXBMessageBodyWriter implements MessageBodyWriter<Object> {
	@Context
	private Providers providers;

	@Override
	public long getSize(Object object, Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		System.out.println("getSize()...");
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		if (classType.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object object, Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> responseHeaders, OutputStream os)
			throws IOException, WebApplicationException {
		JAXBContext jContext = null;
		Marshaller marshaller = null;
		ContextResolver<JAXBContext> contextResolver = null;
		try {
			System.out.println("writeTo()..");
			contextResolver = providers.getContextResolver(JAXBContext.class,
					MediaType.APPLICATION_XML_TYPE);
			jContext = contextResolver.getContext(classType);
			marshaller = jContext.createMarshaller();
			marshaller.marshal(object, os);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		} finally {
			os.close();
		}

	}

}
