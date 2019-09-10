package com.zking.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Order;
import com.zking.bs.domain.OrderItem;
import com.zking.service.OrderService;

public class LookOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println(id);
		OrderService os = new OrderService();
		HttpSession session = request.getSession();
		
		Order o=os.LookOrderService(id);
		List<OrderItem> list=o.getItem();
		
		System.out.println(list);

		session.setAttribute("list", list);
		
		
		request.getRequestDispatcher("orderInfo.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
