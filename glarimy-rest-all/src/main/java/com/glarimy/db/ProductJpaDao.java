package com.glarimy.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.glarimy.api.Product;

@Repository
public class ProductJpaDao implements ProductDAO {
	// @PersistenceContext(unitName = "products")
	private EntityManager em = Persistence.createEntityManagerFactory(
			"products").createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> read(int from, int to) {
		Query query = em.createQuery("from " + Product.class.getName());
		query.setFirstResult(from);
		query.setMaxResults(to - from);
		return query.getResultList();
	}
}