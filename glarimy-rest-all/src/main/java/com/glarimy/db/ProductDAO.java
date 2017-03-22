package com.glarimy.db;

import java.util.List;

import com.glarimy.api.Product;

public interface ProductDAO {
	public List<Product> read(int from, int to);
}
