package com.zking.bs.Dao;

import java.util.List;

import com.zking.bs.domain.Order;
import com.zking.bs.domain.User;

public interface UserDao {
	public void Register(User user) throws Exception;
	
	public User activeUser(String activeCode) throws Exception;
	
	public void activeCode(String activeCode) throws Exception;
	
	public User Login(String username,String password)throws Exception;
	
	public User RegisterEmail(String Email) throws Exception;
	
	public List<User> Modifyuserinfo(String username) throws Exception;
	
	
	public void ModifyUserMessage(String password,String telephone,String username)throws Exception;
	
	public List<Order> Orderlist(int id)throws Exception;
	
	public User OrderlistById(String username)throws Exception;
	
	public User getMessage(String username) throws Exception;
	
	public User getMessageById(int id)throws Exception;
	
	public User registerActive(String username)throws Exception;
	
}
