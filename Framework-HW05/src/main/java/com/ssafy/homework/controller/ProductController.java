// ajax 처리
package com.ssafy.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/list")
	public List<Product> list() throws Exception {
		return productService.selectAll();
	}
	@GetMapping(value = "/detail")
	public Product detail(String id) throws Exception {
		return productService.select(id);
	}
	
	@GetMapping(value ="/delete")
	public List<Product> delete(String id) throws Exception {
		productService.delete(id);
		return productService.selectAll(); 
	}
	
	@PostMapping(value = "/insert")
	public List<Product> insert(Product product) throws Exception {
		productService.insert(product);
		return productService.selectAll();
	}
	
	@PostMapping(value = "/update")
	public List<Product> update(Product product) throws Exception {
		productService.update(product);
		return productService.selectAll();
	}
}
