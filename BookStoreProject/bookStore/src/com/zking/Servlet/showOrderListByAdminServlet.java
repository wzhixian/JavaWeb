package com.zking.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Order;
import com.zking.service.OrderService;

public class showOrderListByAdminServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String receiverName = request.getParameter("receiverName");
		
		
		HttpSession session = request.getSession();
		OrderService os = new OrderService();
		
		List<Order>  admin_cx_list = os.showOrderListByAdmin(id, receiverName);
		
		System.out.println(admin_cx_list);
		session.setAttribute("admin_cx_list", admin_cx_list);
		
		request.getRequestDispatcher("/admin/orders/list.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
