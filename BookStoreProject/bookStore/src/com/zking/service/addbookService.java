package com.zking.service;

import java.sql.SQLException;

import com.zking.bs.DaoImpl.findbookDaoImpl;
import com.zking.bs.domain.Product;

public class addbookService {
	
	public void addbook(Product p){
		findbookDaoImpl fb=new findbookDaoImpl();
		
		try {
			fb.addBook(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
