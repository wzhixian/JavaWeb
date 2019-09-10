package com.zking.bs.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zking.bs.Dao.OrderDao;
import com.zking.bs.domain.Order;
import com.zking.bs.domain.OrderItem;
import com.zking.bs.domain.Product;
import com.zking.bs.util.C3P0;

public class OrderDaoImpl implements OrderDao {

	public void deleteOrder(String id) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		qr.update("DELETE FROM orderitem WHERE order_id=?", id);
		qr.update("delete from orders where id=?", id);
	}

	public Order LookOrder(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from orders,orderitem,products where orders.id=orderitem.order_id and orderitem.product_id=products.id and orders.id=?";
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		return qr.query(sql, new ResultSetHandler<Order>() {

			public Order handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Order order = new Order();

				// 用于封装订单项
				List<OrderItem> list = new ArrayList<OrderItem>();

				while (rs.next()) {
					// 封装订单信息
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setReceiverAddress(rs
							.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverPhone(rs.getString("orders.receiverPhone"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setUser_id(rs.getInt("orders.user_id"));

					// 封装orderitem,orderitem是封装到集合中的

					OrderItem oi = new OrderItem();

					oi.setOrder(order);
					oi.setBuynum(rs.getInt("orderitem.buynum"));
					// System.out.println(oi.getBuynum());
					Product p = new Product();

					p.setId(rs.getString("products.id"));
					p.setCategory(rs.getString("products.category"));
					p.setDescription(rs.getString("products.description"));
					// p.setImgurl(rs.getString("products.imgurl"));
					p.setName(rs.getString("products.name"));
					p.setPnum(rs.getInt("products.pnum"));
					p.setPrice(rs.getDouble("products.price"));
					p.setImgurl(rs.getString("products.imgurl"));

					oi.setP(p);
					list.add(oi);

				}
				order.setItem(list);
				System.out.println(list);
				return order;
			}

		}, id);
	}

	public void CreateOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		String sql="insert into orders values(?,?,?,?,?,?,?,?)";
		qr.update(sql,order.getId(),order.getMoney(),order.getReceiverAddress(),order.getReceiverName(),order.getReceiverPhone(),order.getPaystate(),order.getOrdertime(),order.getUser().getId());
	}

	public void CreateOrderItem(OrderItem oi) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0.getDataSource());
		String sql="insert into orderitem values(?,?,?)";
		qr.update(sql,oi.getOrder().getId(),oi.getP().getId(),oi.getBuynum());
		System.out.println("3");
	}

	public List<Order> showOrderListByAdmin(String id, String receiverName)
			throws Exception {
		String sql = "select * from orders where 1=1 ";
		
		if(id != ""){
			sql = sql + " and id='"+id+"'";
		}
		if(receiverName != ""){
			sql = sql +"and receiverName='"+receiverName+"'";
		}
		
		QueryRunner qr = new QueryRunner(C3P0.getDataSource());
		List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class));
		return list;
	}
}
