package com.ssafy.homework.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.homework.model.dto.Product;

public interface ProductMapper {
	List<Product> selectAllProduct() throws SQLException;
	Product selectProduct(String id) throws SQLException;
	int insertProduct(Product product) throws SQLException;
	int updateProduct(Product product) throws SQLException;
	int deleteProduct(String id) throws SQLException;
}
