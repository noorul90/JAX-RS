package com.jri.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bigbasket")
public class BigBasketResource {

	@Path("/search/{brand}/{pname}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String search(@PathParam("brand") String brand,
			@PathParam("pname") String productName,
			@QueryParam("category") String category,
			@MatrixParam("quantity") int quantity) {

		return "Brand: " + brand + " ProductName: " + productName
				+ " Category: " + category + " Quantity: " + quantity;

	}

}
