package com.zking.Servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Product;
import com.zking.service.ChangeNumService;

public class ChangeNumServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			String id=request.getParameter("id");
			int num=Integer.parseInt(request.getParameter("num"));
			int total = Integer.parseInt(request.getParameter("total"));
			
			//90 90对象属性完全一致  89 90 库存对不上
			ChangeNumService cns=new ChangeNumService();
			
			Product p=cns.changeNum(id);
			System.out.println(p);
			
			@SuppressWarnings("unchecked")
			Map<Product, String> map=(Map<Product, String>) session.getAttribute("buyProduct");
			if(num==0){
				map.remove(p);
			}
			if(map.containsKey(p)){
				map.put(p, num+"");
			}
			cns.updateProduct(id, num, total);
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
			
			//session.setAttribute("buyProduct", map);
			
			//2019-8-19修改
			//response.sendRedirect(request.getContextPath()+"/cart.jsp");
			
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
