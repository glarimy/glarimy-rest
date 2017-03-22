package com.glarimy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glarimy.api.Inventory;
import com.glarimy.api.InventoryException;
import com.glarimy.api.Product;
import com.glarimy.db.ProductDAO;

@Service
public class ProductInventory implements Inventory {
	@Autowired
	private ProductDAO dao;

	@Override
	@Transactional
	public List<Product> fetch(int from, int to) throws InventoryException {
		return dao.read(from, to);
	}
}
