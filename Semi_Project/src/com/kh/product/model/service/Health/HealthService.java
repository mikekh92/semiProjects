package com.kh.product.model.service.Health;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.product.model.dao.Health.HealthDao;
import com.kh.product.model.vo.Product;


public class HealthService {

	public ArrayList<Product> HealthProduct(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new HealthDao().HealthProduct(conn, pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	public int HealthCount() {
		Connection conn = getConnection();
		
		int listCount = new HealthDao().HealthCount(conn);
		
		close(conn);
		
		return listCount;
	}
	public int HealthtpCount(int cateNo) {
		Connection conn = getConnection();
		
		int listCount = new HealthDao().HealthtpCount(conn,cateNo);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Product> HealthtpProduct(PageInfo pitp, int cateNo) {
		Connection conn = getConnection();
		
		ArrayList<Product> listtp = new HealthDao().HealthtpProduct(conn, pitp,cateNo);
		System.out.println(listtp);
		close(conn);
		
		return listtp;
	}


	
	
}
