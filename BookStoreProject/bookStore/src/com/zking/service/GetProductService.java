package com.zking.service;

import java.sql.SQLException;
import java.util.List;

import com.zking.bs.DaoImpl.ProductDaoImpl;
import com.zking.bs.domain.PageBean;
import com.zking.bs.domain.Product;

public class GetProductService {
	
	public List<Product> GetProduct(String name){
		
		ProductDaoImpl pd=new ProductDaoImpl();
		List<Product> list=null;
		try {
			 list=pd.GetBook(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public List<Product> ShowProduct(String category){
		ProductDaoImpl pd=new ProductDaoImpl();
		List<Product> list=null;
		
		try {
			list=pd.ShowProduct(category);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	public PageBean<Product> showProductByPage(int currPage, int pageSize, String category) throws SQLException {
		// TODO Auto-generated method stub
		//查询当前页数据（当前页-1）*每页显示条数，每页显示条数
		ProductDaoImpl  pdl=new ProductDaoImpl();
		
		List<Product> list=pdl.showProductByPage(currPage,pageSize,category);
		
		//查询总条数
		
		int totalCount=pdl.getCount(category);
		return new PageBean<Product>(list, currPage, pageSize, totalCount);
	}
}
