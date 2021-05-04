package com.ssafy.homework.model.service;

import java.util.List;

import com.ssafy.homework.model.dto.Product;

public interface ProductService {
	List<Product> selectAll() throws Exception ;
	Product select(String id) throws Exception ;
	int insert(Product product) throws Exception ;
	int update(Product product) throws Exception ;
	int delete(String id) throws Exception ;
}
