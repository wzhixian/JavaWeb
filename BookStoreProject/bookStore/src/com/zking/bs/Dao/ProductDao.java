package com.zking.bs.Dao;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.domain.Product;



public interface ProductDao {
		
	public List<Product> findBook() throws SQLException;
	
	public List<Product> GetBook(String name) throws SQLException;
	
	public Product BuyBook(String name) throws SQLException;
	
	public Product changeNum(String id) throws SQLException;
	
	public List<Product> ShowProduct(String category) throws SQLException;
	
	public void updateProduct(String id,int num,int total)throws SQLException;
}
