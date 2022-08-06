package com.kh.product.model.service.Boling;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.product.model.dao.Boling.BolingDao;
import com.kh.product.model.vo.Product;


public class BolingService {

	public ArrayList<Product> BolingProduct(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new BolingDao().BolingProduct(conn,pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	public int BolingCount() {
		Connection conn = getConnection();
		
		int listCount = new BolingDao().BolingCount(conn);
		
		close(conn);
		
		return listCount;
	}
	public int BolingtpCount(int cateNo) {
		Connection conn = getConnection();
		
		int listCount = new BolingDao().BolingtpCount(conn,cateNo);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Product> BolingtpProduct(PageInfo pitp, int cateNo) {
		Connection conn = getConnection();
		
		ArrayList<Product> listtp = new BolingDao().BolingtpProduct(conn, pitp,cateNo);
		System.out.println(listtp);
		close(conn);
		
		return listtp;
	}



	
	
}
