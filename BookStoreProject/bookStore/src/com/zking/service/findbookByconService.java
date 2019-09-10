package com.zking.service;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.DaoImpl.findbookDaoImpl;
import com.zking.bs.domain.Product;

public class findbookByconService {
		
	public List<Product> finBookBy(String name,String id, String category) throws SQLException{
		findbookDaoImpl fbdi=new findbookDaoImpl();
		List<Product> list=fbdi.findBookByid(id, name,category);
		return list;
		
	}
}
