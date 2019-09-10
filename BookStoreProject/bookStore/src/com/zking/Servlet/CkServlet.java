package com.zking.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zking.bs.domain.User;
import com.zking.service.UserService;

public class CkServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String Email=request.getParameter("email");
		
		UserService us=new UserService();
		
		User u=us.ckEmail(Email);
		
		if(u!=null){
			out.print(true);
		}else{
			out.print(false);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}

}
