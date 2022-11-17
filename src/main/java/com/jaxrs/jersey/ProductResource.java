package com.jaxrs.jersey;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
    private ProductDAO dao = ProductDAO.getInstance();
    
    //get list of items
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> list() throws SQLException {
        return dao.listAll();
    }  
    
}