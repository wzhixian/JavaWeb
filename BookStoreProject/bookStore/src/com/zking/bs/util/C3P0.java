package com.zking.bs.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
		
	private static ComboPooledDataSource dataSource= new ComboPooledDataSource();
	
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection(){
		
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("·þÎñÆ÷´íÎó");
		}
	}
	
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			stmt=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			conn=null;
		}
	}
	
	
}
