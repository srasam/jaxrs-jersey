package com.jaxrs.jersey;

import java.sql.SQLException;

public class TestDBConnection {

	public static void main(String[] args) throws SQLException {
		ProductDAO b=new ProductDAO();
		//b.connect();
		b.listAll();
		   

	}

}
