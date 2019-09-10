package com.zking.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zking.bs.DaoImpl.UserDaoImpl;
import com.zking.bs.domain.Order;
import com.zking.bs.domain.User;
import com.zking.service.UserService;

public class OrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("username");
		
		UserService us=new UserService();
		
		UserDaoImpl ud=new UserDaoImpl();    
		
		System.out.println(username);
		
		try {
			User u=ud.OrderlistById(username);
			
			int id=u.getId();
			System.out.println(id);
			
			List<Order> list=us.Orderlist(id);
			request.getSession().setAttribute("list", list);
			
			request.getRequestDispatcher("orderlist.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
