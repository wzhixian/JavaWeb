package com.zking.bs.Dao;



import java.util.List;

import com.zking.bs.domain.Order;
import com.zking.bs.domain.OrderItem;

public interface OrderDao {
	public void deleteOrder(String id)throws Exception;
	
	
	public Order LookOrder(String id) throws Exception;
	
	public void CreateOrder(Order order) throws Exception;
	
	public void CreateOrderItem(OrderItem oi) throws Exception;
	
	public List<Order> showOrderListByAdmin(String id,String receiverName) throws Exception;
}