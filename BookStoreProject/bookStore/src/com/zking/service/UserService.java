package com.zking.service;

import java.util.List;

import com.zking.Exception.UserException;
import com.zking.bs.Dao.UserDao;
import com.zking.bs.DaoImpl.UserDaoImpl;
import com.zking.bs.domain.Order;
import com.zking.bs.domain.User;

public class UserService {

	
	public void Register(User user) throws UserException {
		UserDao ud=new UserDaoImpl();
		
		try {
			ud.Register(user);//用户注册
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("注册失败");
		}
	}
	public void activeCode(String activeCode) throws UserException{
		
		try {
			UserDaoImpl ud = new UserDaoImpl();
			User u = ud.activeUser(activeCode);
			System.out.println(u);
			if (u != null) {
				ud.activeCode(activeCode);
				return;
			}
			throw new UserException("激活失败");
		} catch (Exception e) {
			// TODO: handle exception
			throw new UserException("激活失败");
		}
	}
	public User Login(String username,String password) throws UserException{
		
		UserDaoImpl ud=new UserDaoImpl();
		User u=null;
		try {
			u=ud.Login(username, password);
			if(u==null){
				throw new UserException("用户名或者密码错误!");
			}if(u.getState()==0){
				throw new UserException("用户未激活");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("用户名或者密码错误!");
		}
		return u;
		
	}
	public User ckEmail(String Email) {
		// TODO Auto-generated method stub
		UserDaoImpl ud=new UserDaoImpl();
		User u=null;
		try {
			u = ud.RegisterEmail(Email);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public List<User> Modifyuserinfo(String username){
		
		UserDaoImpl ud=new UserDaoImpl();
		List<User> list=null;
		try {
			 list=ud.Modifyuserinfo(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
		
	}
	public void ModifyUserMessage(String password,String telephone,String username){
		
		UserDaoImpl ud=new UserDaoImpl();
		
		try {
			ud.ModifyUserMessage(password, telephone, username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Order> Orderlist( int id){
		
		UserDaoImpl ud=new UserDaoImpl();
		
		List<Order> list=null;
		
		try {
			list=ud.Orderlist(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
		
	}
	public User getMessage(String username){
		
		UserDaoImpl udi=new UserDaoImpl();
		User u=null;
		try {
			 u=udi.getMessage(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
		
	}
	public User getMessageById(int id){
		UserDaoImpl udi=new UserDaoImpl();
		
		User u = null;
		
		try {
			u = udi.getMessageById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
	
	public User registerActive(String username){
		UserDaoImpl udi=new UserDaoImpl();

		User u = null;
		
		try {
			u = udi.registerActive(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
}
