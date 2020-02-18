package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.bean.ProductBean;
import com.product.exceptions.ProductNotFoundException;
import com.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping(value="/addProduct")
	public void addProduct(@RequestBody ProductBean productBean){
		System.out.println("Name==="+productBean.getName());
		productService.addProduct(productBean);
	}
	@GetMapping(value="/getProduct/{id}")
	public Resource<ProductBean> getProductOnId(@PathVariable Integer id){
		Optional<ProductBean> productOpt=productService.getProductOnId(id);
	
		productOpt.orElseThrow(()->new ProductNotFoundException("id:-"+id));
		Resource<ProductBean> resource = new Resource<ProductBean>(productOpt.get());
		return resource;
	}
}
