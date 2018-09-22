package com.ddw.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/courier")
public class CourierResource {
	
	/**
	 * Dynamic Dispatching
	 */
	
	@Path("/{type}/{awbn}-{docId}")
	public Object locateServices(@PathParam("type") String type){
		
		if(type.equals("domestic")){
			return new DomesticCourierSubResource();
		}
		else if(type.equals("international")){
			return new InternationalCourierSubResource();
		}
		
		return null;
		
	}
	
}//http://localhost:8080/DynamicDispatchingWeb/rest/courier/domestic/12-2
//http://localhost:8080/DynamicDispatchingWeb/rest/courier/international/12-2
