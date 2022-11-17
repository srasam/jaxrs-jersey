package com.jaxrs.jersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {

    private Connection jdbcConnection;
     

    
    public void connect() throws SQLException {
    	System.out.println("BookDAO->connect(): jdbcConnection 1: " + this.jdbcConnection);
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
		    	System.out.println("BookDAO->connect(): jdbcConnection 2: " + this.jdbcConnection);
		    	jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?enabledTLSProtocols=TLSv1.2", "root", "root");
		    	System.out.println("BookDAO->connect(): jdbcConnection 3: " + this.jdbcConnection);
		    	System.out.println("Successfully connected to DB");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	 private static ProductDAO instance;
    public ProductDAO() {
	         
	    }
	     
	    public static ProductDAO getInstance() {
	        if (instance == null) {
	            instance = new ProductDAO();
	        }
	         
	        return instance;               
	    }
	     
	    public List<Product> listAll() throws SQLException {
	    	 List<Product> listProduct = new ArrayList<>();
	         
	         String sql = "SELECT * FROM products";
	          
	         connect();
	          
	         Statement statement = jdbcConnection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql);
	          
	         while (resultSet.next()) {
	             int id = resultSet.getInt("id");
	             String name = resultSet.getString("name");
	             float price = resultSet.getFloat("price");
	              
	             Product product = new Product(id, name, price);
	             listProduct.add(product);
	         }
	         System.out.println(listProduct.size());
	         listProduct.forEach(System.out::println);
	          
	         resultSet.close();
	         statement.close();
	          
	         
	          
	         return listProduct;
	    }
	     
}
