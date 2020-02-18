package com.product.service;

import java.util.Optional;

import com.product.bean.ProductBean;

public interface ProductService {
public void addProduct(ProductBean bean);

public Optional<ProductBean>getProductOnId(Integer id);
}
