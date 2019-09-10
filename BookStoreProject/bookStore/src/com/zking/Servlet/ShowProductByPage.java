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
		
		//��ȡ�ڼ�ҳ
		int currPage=Integer.parseInt(request.getParameter("currPage"));
		
		//�̶�ÿҳ��ʾ����
		int pageSize=4;
		
		//����Service��ɷ�ҳ��ѯ ����ֵPageBean
		GetProductService gps=new GetProductService();
		PageBean<Product> pb=null;
		
		try {
			 pb=gps.showProductByPage(currPage,pageSize,category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��PageBean����request���У�������ת��
		
		
		
		HttpSession session=request.getSession();
		
		session.setAttribute("pb",pb);
		
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
