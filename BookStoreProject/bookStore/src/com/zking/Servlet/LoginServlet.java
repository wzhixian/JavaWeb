package com.zking.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.User;
import com.zking.service.UserService;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		UserService us=new UserService();
		
		try {
			User u=us.Login(username, password);
			String path="/index.jsp";
			if("admin".equals(u.getRole())){
				path="/admin/login/home.jsp";
			}
			session.setAttribute("username",username);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("user_msg", "ÓÃ»§Î´¼¤»î");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
