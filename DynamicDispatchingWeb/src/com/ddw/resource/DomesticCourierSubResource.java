package com.ddw.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class DomesticCourierSubResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCourierStatus(@PathParam("awbn") String awbn){
		
		return "Awbn: " + awbn + " is ready for delivery";
		
	}
	
}