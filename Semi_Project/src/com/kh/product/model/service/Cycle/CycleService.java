package com.kh.product.model.service.Cycle;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.product.model.dao.Cycle.CycleDao;
import com.kh.product.model.vo.Product;


public class CycleService {

	public ArrayList<Product> CycleProduct(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new CycleDao().CycleProduct(conn,pi);
		System.out.println(list);
		close(conn);
		
		return list;
		
	}
	public int CycleCount() {
		Connection conn = getConnection();
		
		int listCount = new CycleDao().CycleCount(conn);
		
		close(conn);
		
		return listCount;
	}
	public ArrayList<Product> CycletpProduct(PageInfo pitp, int cateNo) {
		Connection conn = getConnection();
		
		ArrayList<Product> listtp = new CycleDao().CycletpProduct(conn, pitp,cateNo);
		System.out.println(listtp);
		close(conn);
		
		return listtp;
	}
	public int CycletpCount(int cateNo) {
		Connection conn = getConnection();
		
		int listCount = new CycleDao().CycletpCount(conn,cateNo);
		
		close(conn);
		
		return listCount;
	}

	
	
}
