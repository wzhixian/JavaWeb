package com.zking.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.bs.domain.PageBean;
import com.zking.bs.domain.Product;
import com.zking.service.GetProductService;

public class ShowProductByPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category=request.getParameter("category");
		//String currPage=request.getParameter("currPage");
		//System.out.println(currPage);
		
		//获取第几页
		int currPage=Integer.parseInt(request.getParameter("currPage"));
		
		//固定每页显示条数
		int pageSize=4;
		
		//调用Service完成分页查询 返回值PageBean
		GetProductService gps=new GetProductService();
		PageBean<Product> pb=null;
		
		try {
			 pb=gps.showProductByPage(currPage,pageSize,category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将PageBean放入request域中，并请求转发
		
		
		
		HttpSession session=request.getSession();
		
		session.setAttribute("pb",pb);
		
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
