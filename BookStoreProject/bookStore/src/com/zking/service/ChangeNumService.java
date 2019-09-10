package com.zking.service;

import java.sql.SQLException;

import com.zking.bs.DaoImpl.ProductDaoImpl;
import com.zking.bs.domain.Product;

public class ChangeNumService {
	
	public Product changeNum(String id){
		
		ProductDaoImpl pdl=new ProductDaoImpl();
		
		Product p=null;
		try {
			p = pdl.changeNum(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public void updateProduct(String id,int num,int total){
		ProductDaoImpl pdl=new ProductDaoImpl();
		try {
			pdl.updateProduct(id, num, total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
