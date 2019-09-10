package com.zking.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Product;
import com.zking.service.findbookByconService;

public class findProductbookByadtion extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String category=request.getParameter("category");
		
		findbookByconService fb=new findbookByconService();
		HttpSession session=request.getSession();
		
		try {
			List<Product> list=fb.finBookBy(name, id,category);
			
			session.setAttribute("cx_list", list);
			request.getRequestDispatcher("admin/products/list.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
