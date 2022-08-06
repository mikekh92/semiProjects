package com.kh.product.model.service.Soccer;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.product.model.dao.Soccer.SoccerDao;
import com.kh.product.model.vo.Product;


public class SoccerService {
//Soccer list
	public ArrayList<Product> SoccerProduct(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new SoccerDao().SoccerProduct(conn,pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	public ArrayList<Product> SoccertpProduct(PageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<Product> list = new SoccerDao().SoccertpProduct(conn,pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	public ArrayList<Product> SoccermdProduct(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Product> list = new SoccerDao().SoccermdProduct(conn,pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	public ArrayList<Product> SoccerbtProduct(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Product> list = new SoccerDao().SoccerbtProduct(conn,pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	
	
	
//	Soccer Count
	public int SoccerCount() {
		Connection conn = getConnection();
		
		int listCount = new SoccerDao().SoccerCount(conn);
		
		close(conn);
		
		return listCount;
	}
	public int SoccertpCount() {
		Connection conn = getConnection();
		
		int listCount = new SoccerDao().SoccertpCount(conn);
		
		close(conn);
		
		return listCount;
	}
	public int SoccermdCount() {
		Connection conn = getConnection();
		
		int listCount = new SoccerDao().SoccermdCount(conn);
		
		close(conn);
		
		return listCount;
	}
	public int SoccerbtCount() {
		Connection conn = getConnection();
		
		int listCount = new SoccerDao().SoccerbtCount(conn);
		
		close(conn);
		
		return listCount;
	}




	
	
}
