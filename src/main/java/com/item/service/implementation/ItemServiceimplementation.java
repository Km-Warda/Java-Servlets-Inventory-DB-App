package com.item.service.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;

public class ItemServiceimplementation implements ItemService {
	
	
	private DataSource dataSource;
	public ItemServiceimplementation (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	// To ensure class usage after proper connection to database
	
	
	
	
	@Override
	public boolean addItem(Item item) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "INSERT INTO item (NAME, PRICE, TOTAL_NUMBER) VALUES ('" + item.getName() + "'," + item.getPrice() + ","+ item.getTotalNumber() + ")";
			Statement statement = connection.createStatement();
			int affectedRows = statement.executeUpdate(query);
			return affectedRows > 0;   // true if at least one row deleted
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean removeItem(int id) {
	    try {
	        Connection connection = dataSource.getConnection();
	        String query = "DELETE FROM item WHERE id = " + id;
	        Statement statement = connection.createStatement();
	        int affectedRows = statement.executeUpdate(query);
	        return affectedRows > 0; // true if at least one row deleted
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	@Override
	public boolean updateItem(Item item) {
	    try {
	        Connection connection = dataSource.getConnection();
	        String query = "UPDATE item SET " + "NAME = '" + item.getName() + "', " + "PRICE = " + item.getPrice() + ", " + "TOTAL_NUMBER = " + item.getTotalNumber() + " WHERE ID = " + item.getId();
	        Statement statement = connection.createStatement();
	        int affectedRows = statement.executeUpdate(query); 
	        return affectedRows > 0; // true if at least one row deleted
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	@Override
	public Item loadItem(int id) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "SELECT * FROM item WHERE id = " + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				return new Item(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("price"),
						resultSet.getInt("total_number")
						);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Item> listItems() {
		try {
			// `Connection` is a standard JDBC class.
			Connection connection = dataSource.getConnection();
			String query = "SELECT * FROM item";
			// `Statement` is used to execute **static SQL queries** (ones without user input)
			// If you were using dynamic values (like from a form), you'd use `PreparedStatement` instead
			Statement statement = connection.createStatement();
			// ResultSet is a cursor-like object that lets you iterate over the rows returned from the query.
			ResultSet resultSet = statement.executeQuery(query);
			List<Item> all_items = new ArrayList<Item>();
			// next() moves the cursor to the next row (starting before the first row by default).
			while (resultSet.next()) {
				Item item = new Item(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("price"),
						resultSet.getInt("total_number")
						);
				all_items.add(item);
			}
			return all_items;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
