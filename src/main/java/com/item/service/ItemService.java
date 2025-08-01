package com.item.service;
import java.util.List;
import com.item.model.Item;

public interface ItemService {
	boolean addItem(Item item);
	boolean removeItem(int id);
	boolean updateItem(Item item);
	Item loadItem(int id);
	List<Item> listItems();
}	
