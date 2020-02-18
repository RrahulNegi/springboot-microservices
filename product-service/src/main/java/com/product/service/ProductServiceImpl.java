package com.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.bean.ProductBean;
import com.product.dao.ProductDao;

@Component
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	public void addProduct(ProductBean bean) {
		productDao.addProduct(bean);
		
	}

	public Optional<ProductBean> getProductOnId(Integer id) {
		return productDao.getProductOnId(id);
	}

}
