package com.zking.service;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.DaoImpl.ProductDaoImpl;
import com.zking.bs.domain.Product;

public class bookstoreImpl {
		
	public List<Product> findBooklist() throws SQLException{
		
		ProductDaoImpl b=new ProductDaoImpl();
		
		List<Product> list=b.findBook();
		return list;
		
		
	}
}
