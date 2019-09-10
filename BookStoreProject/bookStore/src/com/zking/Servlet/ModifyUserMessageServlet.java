package com.zking.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.service.UserService;

public class ModifyUserMessageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String password=request.getParameter("password");
		String telephone=request.getParameter("telephone");
		
		
		
		UserService us=new UserService();
		
		us.ModifyUserMessage(password, telephone, username);
		
		request.getRequestDispatcher("myAccount.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
		
	}

}
