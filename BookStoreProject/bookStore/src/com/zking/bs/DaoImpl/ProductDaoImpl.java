package com.zking.bs.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zking.bs.Dao.ProductDao;
import com.zking.bs.domain.Product;
import com.zking.bs.util.C3P0;



public class ProductDaoImpl implements ProductDao{
		
	public List<Product> findBook() throws SQLException{
		
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		List<Product> list=qr.query("select * from  products", new BeanListHandler<Product>(Product.class));
		
		return list;
	}

	public List<Product> GetBook(String name) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		String sql = "select * from products where name=?";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),name);
		
		return list;
	}

	public Product BuyBook(String name) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		
		Product list=qr.query("select * from products where name=?", new BeanHandler<Product>(Product.class),name);
		return list;
	}

	public Product changeNum(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		Product p=qr.query("select * from products where id=?", new BeanHandler<Product>(Product.class),id);
		return p;
	}
	
	public void updateProduct(String id,int num,int total) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		String sql = "update products set pnum=? where id=?";
		qr.update(sql,(total-num),id);
	}

	public List<Product> ShowProduct(String category) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		
		List<Product> list=qr.query("select * from products where category=?", new BeanListHandler<Product>(Product.class),category);
		return list;
	}

	public List<Product> showProductByPage(int currPage, int pageSize, String category) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		//String sql="select * from products where category=? limit ?,?";
		String sql="select * from products where 1=1 ";
		String sql1 = "select * from products";
		if(category!=null){
			sql=sql+" and category=? limit ?,?";
		}
		if(category==null){
			sql=sql+"limit ?,?";
			return qr.query(sql, new BeanListHandler<Product>(Product.class),(currPage-1)*pageSize,pageSize);
		}
//		System.out.println(qr.query(sql1, new BeanListHandler<Product>(Product.class)));
//		System.out.println(qr.query(sql, new BeanListHandler<Product>(Product.class),category,(currPage-1)*pageSize,pageSize));
		return qr.query(sql, new BeanListHandler<Product>(Product.class),category,(currPage-1)*pageSize,pageSize);
	}

	public int getCount(String category) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		//String sql="select count(*) from products where category=?";
		String sql="select count(*) from products where 1=1"; 
		if(category!=null){
			sql=sql+" and category=?";
		}
		if(category==null){
			return ((Long)qr.query(sql, new ScalarHandler())).intValue();
		}
		
		return ((Long)qr.query(sql, new ScalarHandler(),category)).intValue();
		
	}
	
	

	
}
