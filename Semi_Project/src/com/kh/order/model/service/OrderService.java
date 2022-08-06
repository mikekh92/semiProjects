package com.kh.order.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.order.model.dao.OrderDao;
import com.kh.order.model.vo.Order;

public class OrderService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new OrderDao().selectListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList <Order> selectOrderList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList <Order> list = new OrderDao().selectOrderList(conn,pi);
		
		close(conn);
		return list;
	}

}
