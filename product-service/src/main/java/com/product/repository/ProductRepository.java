package com.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.bean.ProductBean;
@Repository
public interface ProductRepository extends CrudRepository<ProductBean, Integer> {

}
