package com.zking.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import com.zking.bs.domain.Product;
import com.zking.bs.util.UUIDutil;
import com.zking.service.addbookService;

public class addBookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Product p=new Product();
			
			try {
				BeanUtils.populate(p, request.getParameterMap());
				p.setId(UUIDutil.getUUID());
				//调用业务逻辑
				addbookService add=new addbookService();
				add.addbook(p);
				response.sendRedirect("findProductByManyCondition");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
