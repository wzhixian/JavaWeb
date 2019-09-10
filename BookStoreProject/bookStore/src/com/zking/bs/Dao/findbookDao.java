package com.zking.bs.Dao;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.domain.Product;

public interface findbookDao {
	public List<Product> findBookByid(String id,String name,String category) throws SQLException;
	
	public void deleBook(String id)  throws SQLException;
	
	public void addBook(Product p) throws SQLException;
	
	public void xiuGaiBook(Product p,String id)throws SQLException;
	
	public List<Product> lookBook(String id)throws SQLException;

	
}