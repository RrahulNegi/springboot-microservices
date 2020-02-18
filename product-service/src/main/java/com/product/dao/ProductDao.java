package com.product.dao;

import java.util.Optional;

import com.product.bean.ProductBean;

public interface ProductDao {
	public void addProduct(ProductBean bean);

	public Optional<ProductBean>getProductOnId(Integer id);
}
