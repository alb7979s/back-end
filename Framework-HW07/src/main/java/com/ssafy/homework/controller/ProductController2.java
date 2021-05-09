/*	REST 방식
 * 	/product2 		- GET 전체조회
 * 	/product2/p01 	- GET 상세조회
 * 	/product2/p01 	- DELETE 삭제
 * 	/product2	 	- POST 등록
 * 	/product2	 	- PUT 수정
 */
package com.ssafy.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.service.ProductService;

@RestController
@RequestMapping("/product2")
public class ProductController2 {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> list() throws Exception {
		return productService.selectAll();
	}
	
	@GetMapping("{id}")
	public Product detail(@PathVariable("id") String id) throws Exception {
		return productService.select(id);
	}
	
	@DeleteMapping("{id}")
	public List<Product> delete(@PathVariable("id") String id) throws Exception {
		productService.delete(id);
		return productService.selectAll(); 
	}
	
	// @RequestBody 쓰는 이유: 화면에서 넘어오는 값이 name=value 형태가 아니라 {key:value}형태로 넘어오는 경우	
	@PostMapping
	public List<Product> insert(@RequestBody Product product) throws Exception {
		productService.insert(product);
		return productService.selectAll();
	}
	
	@PutMapping
	public List<Product> update(@RequestBody Product product) throws Exception {
		productService.update(product);
		return productService.selectAll();
	}
}
