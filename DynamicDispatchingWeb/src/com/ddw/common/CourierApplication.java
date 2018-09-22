package com.ddw.common;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")  // to avoid writting web.xml file completely
public class CourierApplication extends ResourceConfig {

	/**
	 * if you want to make the resource class singleton then you have to
	 * register the class manually otherwise it will register automatically for
	 * non-singleton, so no need to write any extra code in this class for
	 * making the resource as non-singleton
	 */

}
