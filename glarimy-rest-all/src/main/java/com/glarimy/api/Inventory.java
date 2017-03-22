package com.glarimy.api;

import java.util.List;

public interface Inventory {
	public List<Product> fetch(int from, int to) throws InventoryException;
}
