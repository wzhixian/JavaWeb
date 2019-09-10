package com.zking.service;

import java.util.ArrayList;
import java.util.List;

import com.zking.bs.DaoImpl.OrderDaoImpl;
import com.zking.bs.domain.Order;
import com.zking.bs.domain.OrderItem;

public class OrderService {
	public void deleteService(String id) {

		OrderDaoImpl od = new OrderDaoImpl();

		try {
			od.deleteOrder(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Order LookOrderService(String id) {

		OrderDaoImpl odi = new OrderDaoImpl();

	
		Order o=null;
		try {
			 o = odi.LookOrder(id);

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;

	}
	public void addOrder(Order order){
		OrderDaoImpl odi=new OrderDaoImpl();
		
		try {
			odi.CreateOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addOrderItem(OrderItem oi){
		OrderDaoImpl odi=new OrderDaoImpl();
		try {
			odi.CreateOrderItem(oi);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List<Order> showOrderListByAdmin(String id,String receiverName){
		OrderDaoImpl  odi = new OrderDaoImpl();
		
		List<Order> list = null;
		try {
			 list = odi.showOrderListByAdmin(id, receiverName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
