package com.zking.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.Product;
import com.zking.service.BuyProductService;

public class BuyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setContentType("text/html;charset=utf-8");
			
			String name=request.getParameter("bookname");
			
			BuyProductService bps=new BuyProductService();
			
			Product p=bps.BuyProduct(name);
			
			System.out.println(p);
			
			HttpSession session=request.getSession();
			
			@SuppressWarnings("unchecked")
			Map<Product,String> map=(Map<Product, String>) session.getAttribute("buyProduct");
			
			int num=1;
			
			if(map==null){
				map=new LinkedHashMap<Product, String>();
			}
			//����ͬһ��ʱ���ж��ǲ���ͬһ������P �������жϵ���p�ĵ�ֵַ ���� ��Ҫ�������ĵ�ֵַ��Ϊһ�� hashcode equals
			if(map.containsKey(p)){
				num=Integer.parseInt(map.get(p))+1;
			}
			
			map.put(p, num+"");
			
			System.out.println(map);
			
			session.setAttribute("buyProduct", map);
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
