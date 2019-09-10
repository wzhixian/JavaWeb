package com.zking.service;

import java.sql.SQLException;

import com.zking.bs.DaoImpl.findbookDaoImpl;
import com.zking.bs.domain.Product;

public class XiuGaibookService {
		
	public void xiugaiBook(Product p,String id) throws SQLException{
		findbookDaoImpl fb=new findbookDaoImpl();
		
		fb.xiuGaiBook(p, id);
	}
}
