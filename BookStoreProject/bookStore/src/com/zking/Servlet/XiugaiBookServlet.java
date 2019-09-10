package com.zking.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zking.bs.domain.Product;
import com.zking.service.XiuGaibookService;
import org.apache.commons.beanutils.BeanUtils;

public class XiugaiBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		
		Product p=new Product();
		
		try {
			BeanUtils.populate(p, request.getParameterMap());
			p.setId(id);
			//调用业务逻辑s
			XiuGaibookService xg=new XiuGaibookService();
			System.out.println(id);
			System.out.println(p);
			xg.xiugaiBook(p, id);
			
			response.sendRedirect("findProductByManyCondition");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
