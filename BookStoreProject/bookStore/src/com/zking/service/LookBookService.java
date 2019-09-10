package com.zking.service;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.DaoImpl.findbookDaoImpl;
import com.zking.bs.domain.Product;

public class LookBookService {
		public List<Product> lookBook(String id) throws SQLException{
			
			findbookDaoImpl fb=new findbookDaoImpl();
			List<Product> list=fb.lookBook(id);
			return list;
			
			
		}
}
