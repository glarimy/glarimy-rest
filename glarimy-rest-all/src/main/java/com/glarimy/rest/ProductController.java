package com.glarimy.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.glarimy.api.Inventory;
import com.glarimy.api.Product;

@Path("/")
public class ProductController {
	@Autowired
	private Inventory inventory;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@QueryParam("from") int from, @QueryParam("to") int to) {
		List<Product> products = inventory.fetch(from, to);
		return Response.ok().entity(new GenericEntity<List<Product>>(products) {
		}).build();
	}
}
