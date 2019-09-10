package com.zking.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zking.Exception.UserException;
import com.zking.bs.domain.User;
import com.zking.bs.util.UUIDutil;
import com.zking.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		//��֤ע����
			String ckcode=req.getParameter("ckcode");
			String checkcode_session=(String)req.getSession().getAttribute("checkcode_session");
			if(!checkcode_session.equals(ckcode)){
				System.out.println(ckcode);
				req.setAttribute("ckmessage", "��֤�����");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
				return;
			}
		//��ȡ������
		User user=new User();
		
		try {
			BeanUtils.populate(user, req.getParameterMap());
			user.setActiveCode(UUIDutil.getUUID());
			String username = user.getUsername();
			//����ҵ���߼�
			UserService us=new UserService();
			us.Register(user);
			//����ת��
			//req.getSession().setAttribute("user",user);
			String activeCode = us.registerActive(username).getActiveCode();
			session.setAttribute("activeCode", activeCode);
			req.getRequestDispatcher("/registerActive.jsp").forward(req, resp);
			
		}catch(UserException e){
			
			req.setAttribute("user_msg", e.getMessage());
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(req, resp);
	}
}
