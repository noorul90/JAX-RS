package com.sw.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stock")
public class StockTrade {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/price/{stockName}")
	public float getStockPrice(@PathParam("stockName") String stockName){
		
		return 452.25f;
		
	}

}
