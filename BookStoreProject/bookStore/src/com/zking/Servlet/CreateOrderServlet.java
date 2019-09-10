package com.zking.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Order;
import com.zking.bs.domain.OrderItem;
import com.zking.bs.domain.Product;
import com.zking.bs.domain.User;
import com.zking.service.OrderService;
import com.zking.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

public class CreateOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			String receiverAddress=request.getParameter("receiverAddress");
//			String receiverName=request.getParameter("receiverName");
//			String receiverPhone=request.getParameter("receiverPhone");
//			
//			System.out.println(receiverPhone);
		Order order=new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
			order.setId(UUID.randomUUID().toString());

			System.out.println(order);
		} catch (Exception e) {
			// TODO: handle exception
		}
		HttpSession session=request.getSession();
		Map<Product, String> map=(Map<Product, String>) session.getAttribute("buyProduct");
		String username=(String) session.getAttribute("username");
		
		UserService us=new UserService();
		
		User u=us.getMessage(username);
		
		order.setUser(u);
		
		List<OrderItem> list=new ArrayList<OrderItem>();
		OrderService os=new OrderService();
		
		OrderItem o=new OrderItem();
		
		
		//order.setItem(list);
		
		
		os.addOrder(order);
		
		for (Product p : map.keySet() ) {
			
			o.setOrder(order);
			o.setP(p);
			o.setBuynum(Integer.parseInt(map.get(p)));
			
			//list.add(o);
			System.out.println(o);
			os.addOrderItem(o);
			
			
		}
		request.getRequestDispatcher("pay.jsp").forward(request, response);
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
