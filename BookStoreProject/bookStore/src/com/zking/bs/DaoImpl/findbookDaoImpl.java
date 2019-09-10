package com.zking.bs.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zking.bs.Dao.findbookDao;
import com.zking.bs.domain.Product;
import com.zking.bs.util.C3P0;
import com.zking.bs.util.UUIDutil;

public class findbookDaoImpl implements findbookDao {

	public List<Product> findBookByid(String id, String name,String category)
			throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from products where 1=1";

		if (id != "") {
			sql = sql + " and id='" + id + "'";
		}
		if (name != "") {
			sql = sql + " and name like '%" + name + "%'";
		}if(category != ""){
			sql = sql +" and category='"+category+"'";
		}
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(
				Product.class));
		return list;
	}

	public void deleBook(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		qr.update("delete from products where id=?", id);

	}

	public void addBook(Product p) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		qr.update("insert into products values (?,?,?,?,?,?,?)", p.getId(),
				p.getName(), p.getPrice(), p.getCategory(), p.getPnum(),
				p.getImgurl(), p.getDescription());
	}

	public void xiuGaiBook(Product p,String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		qr.update("update products set name=? ,price=?,pnum=?,category=?,imgurl=?,description=? where id=?",
				
				p.getName(),p.getPrice(),p.getPnum(),p.getCategory(),p.getImgurl(),p.getDescription(),p.getId());
	}

	public List<Product> lookBook(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		List<Product> list=qr.query("select * from products where id='"+id+"'", new BeanListHandler<Product>(Product.class));
		return list;
	}
}
