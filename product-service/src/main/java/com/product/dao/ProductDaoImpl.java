package com.product.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.product.bean.ProductBean;
import com.product.repository.ProductRepository;
@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(ProductBean bean) {
		productRepository.save(bean);

	}

	public Optional<ProductBean> getProductOnId(Integer id) {
		return productRepository.findById(id);
	}

}
