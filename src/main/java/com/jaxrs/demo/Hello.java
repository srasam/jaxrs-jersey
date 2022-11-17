package com.jaxrs.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String helloRest() {
		return "Hello world restful web service";
	}
}
