package com.ssafy.homework.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.repository.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productRepo;

	@Override
	public List<Product> selectAll() throws Exception {
		return productRepo.selectAllProduct();
	}

	@Override
	public Product select(String id) throws Exception {
		return productRepo.selectProduct(id);
	}

	@Override
	public int insert(Product product) throws Exception {
		return productRepo.insertProduct(product);
	}

	@Override
	public int update(Product product) throws Exception {
		return productRepo.updateProduct(product);
	}

	@Override
	public int delete(String id) throws Exception {
		return productRepo.deleteProduct(id);
	}

}
