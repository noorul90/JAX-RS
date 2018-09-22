package com.apw.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bse")
public class BSEExchangeResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/stock/{stockNm}")
	public void getStockPrice(@PathParam("stockNm") String stockName,
			@Suspended final AsyncResponse asyncResponse) {
		new Thread(){
			public void run(){
				//database logic
				asyncResponse.resume(Response.ok().entity(523.5f).build());
			};
		}.start();

	}

}
