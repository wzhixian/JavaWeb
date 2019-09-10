package com.zking.bs.domain;

public class OrderItem {
	private Order order;//订单
	private Product p; //商品
	private int buynum; //购物数量
	public OrderItem() {
	
	}
	public OrderItem(Order order, Product p, int buynum) {
		super();
		this.order = order;
		this.p = p;
		this.buynum = buynum;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", p=" + p + ", buynum=" + buynum
				+ "]";
	}
	
	
	
}
