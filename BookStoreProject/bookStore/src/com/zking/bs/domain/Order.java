package com.zking.bs.domain;

import java.sql.Date;
import java.util.List;

public class Order {
	private String id; // �������
	private double money; // �����ܼ�
	private String receiverAddress; // �ͻ���ַ
	private String receiverName; // �ջ�������
	private String receiverPhone; // �ջ��˵绰
	private int paystate; // ����״̬
	private Date ordertime; // �µ�ʱ��
	private List<OrderItem> Item;
	private User user;
	private OrderItem orderItem;
	private int  user_id;
	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Order() {
	
	}
	
	

	public Order(String id, double money, String receiverAddress,
			String receiverName, String receiverPhone, int paystate,
			Date ordertime, List<OrderItem> item, User user, OrderItem orderItem) {
		super();
		this.id = id;
		this.money = money;
		this.receiverAddress = receiverAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.paystate = paystate;
		this.ordertime = ordertime;
		Item = item;
		this.user = user;
		this.orderItem = orderItem;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public int getPaystate() {
		return paystate;
	}
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public List<OrderItem> getItem() {
		return Item;
	}
	public void setItem(List<OrderItem> item) {
		Item = item;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
