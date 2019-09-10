package com.zking.service;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.DaoImpl.ProductDaoImpl;
import com.zking.bs.domain.Product;

public class BuyProductService {
		public Product BuyProduct(String name){
			
			ProductDaoImpl pd=new ProductDaoImpl();
			Product p=null;
			try {
				 p=pd.BuyBook(name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;
			
			
		}
}
