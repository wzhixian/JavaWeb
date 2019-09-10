package com.zking.bs.DaoImpl;



import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zking.bs.Dao.UserDao;
import com.zking.bs.domain.Order;
import com.zking.bs.domain.User;
import com.zking.bs.util.C3P0;

public class UserDaoImpl implements UserDao{

	public void Register(User user) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		String sql="insert into user " +
				"(username,password,gender,email,telephone,introduce,activecode,state,registTime)" +
				" values (?,?,?,?,?,?,?,?,?)";
		qr.update(sql, user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRegistTime());
	}

	
	public User activeUser(String activeCode) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		User u=qr.query("select * from user where activeCode=?", new BeanHandler<User>(User.class),activeCode);
		return u;
	}


	
	public void activeCode(String activeCode) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		qr.update("update user set state=1 where activeCode=?",activeCode);	
	}


	
	public User Login(String username, String password) throws Exception {
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
	
		return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),username,password);
	}


	public User RegisterEmail(String Email) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		return qr.query("select * from user where email=?", new BeanHandler<User>(User.class),Email);
		
	}


	public List<User> Modifyuserinfo(String username) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		return (List<User>) qr.query("select * from user where username=?", new BeanListHandler<User>(User.class),username);
	}


	public void ModifyUserMessage(String password,String telephone,String username) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		qr.update("update user set password=?,telephone=? where username=?",password,telephone,username);
	}


	public List<Order> Orderlist(int id) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		
		return qr.query("select * from orders where  user_id=?", new BeanListHandler<Order>(Order.class),id);

 
	}


	public User OrderlistById(String username) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		
		return qr.query("select * from user where username=?", new BeanHandler<User>(User.class),username);
	}


	public User getMessage(String username) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		User u=qr.query("select * from user where username=?", new BeanHandler<User>(User.class),username);
		return u;
	}


	public User getMessageById(int id) throws Exception {
		String sql = "select * from user where id = ?";
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		User u = qr.query(sql, new BeanHandler<User>(User.class),id);
		return u;
	}


	public User registerActive(String username) throws Exception {
		String sql = "select * from user where username=?";
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		User u = qr.query(sql, new BeanHandler<User>(User.class),username);
		
		return u;
	}


	

}
