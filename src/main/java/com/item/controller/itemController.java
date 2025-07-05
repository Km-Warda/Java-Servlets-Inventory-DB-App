package com.item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;
import com.item.service.implementation.ItemServiceimplementation;


/**
 * Servlet implementation class itemController
 */

@WebServlet("/itemController")
public class itemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/connection")
	private DataSource dataSource;

       

    public itemController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// When calling $URL?actions=$VALUE
		// For example, http://localhost:8080/FORM?action=load-items
		// actions = {Null, add-item, update-item, remove-item, load-item, list-items}
		String action = request.getParameter("action");
		if (Objects.isNull(action)) {
			action = "list-items";
		}
		switch (action) {
			case "add-item":
				addItem(request, response);
				break;
			case "remove-item":
				removeItem(request, response);
				break;
			case "update-item":
				updateItem(request, response);
				break;
			case "load-item":
				loadItem(request, response);				
				break;
			case "list-items":
				listItems(request, response);
				break;
			default:
				listItems(request, response);
		}
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceimplementation(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    int price = Integer.parseInt(request.getParameter("price"));
	    int totalNumber = Integer.parseInt(request.getParameter("total_number"));
        Item item = new Item(id, name, price, totalNumber);
        boolean updatedItem = itemService.updateItem(item);
        request.setAttribute("updatedItem", updatedItem);
        request.setAttribute("updatedItemID", id);
        try {
			request.getRequestDispatcher("/updateItem.jsp").forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());;
		}

	}

	private void listItems(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceimplementation(dataSource);
		List<Item> allItems = itemService.listItems();
		request.setAttribute("allItems", allItems);
		try {
			request.getRequestDispatcher("/listItems.jsp").forward(request,response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void loadItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceimplementation(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
		Item item = itemService.loadItem(id);
		request.setAttribute("item", item);
		try {
			request.getRequestDispatcher("/loadedItem.jsp").forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceimplementation(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
		Boolean removedItem = itemService.removeItem(id);
		request.setAttribute("removalStatus", removedItem);
        request.setAttribute("removedId", id);
        try {
			request.getRequestDispatcher("/removeResult.jsp").forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceimplementation(dataSource);
	    String name = request.getParameter("name");
	    int price = Integer.parseInt(request.getParameter("price"));
	    int totalNumber = Integer.parseInt(request.getParameter("total_number"));
        Item item = new Item(1, name, price, totalNumber);
        boolean addedItem = itemService.addItem(item);
        request.setAttribute("addedItem", addedItem);
		try {
			request.getRequestDispatcher("/addItem.jsp").forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}


}
