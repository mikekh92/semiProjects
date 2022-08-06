package com.kh.detail.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.detail.model.dao.detailDao;
import com.kh.product.model.vo.Product;

public class detailService {


	public ArrayList<Product> detailselect(int pc) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new detailDao().detailselect(conn,pc);
		
		close(conn);
		
		return list;
	}

}
