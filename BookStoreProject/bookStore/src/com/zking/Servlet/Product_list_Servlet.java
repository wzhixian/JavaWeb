package com.zking.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Product;
import com.zking.service.GetProductService;

public class Product_list_Servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name=request.getParameter("bookname");
			
			GetProductService gps=new GetProductService();
			
			List<Product> list=gps.GetProduct(name);
			
			System.out.println(list);
			
			HttpSession session=request.getSession();
			
			session.setAttribute("produst_list", list);
			
			request.getRequestDispatcher("product_info.jsp").forward(request, response);
			
			
			
			
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
