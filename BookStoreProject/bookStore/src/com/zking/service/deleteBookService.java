package com.zking.service;

import java.sql.SQLException;

import com.zking.bs.DaoImpl.findbookDaoImpl;

public class deleteBookService {
		public void delBook(String id){
			findbookDaoImpl fb=new findbookDaoImpl();
			try {
				fb.deleBook(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}	
