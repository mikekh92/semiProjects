package com.kh.order.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.PageInfo;
import com.kh.order.model.vo.Order;
import com.kh.review.model.dao.ReviewDao;

import static com.kh.common.JDBCTemplate.*;

public class OrderDao {
	
	private Properties prop = new Properties();
	
	public OrderDao() {
		String fileName=OrderDao.class.getResource("/db/order/order-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn) {
		
		int listCount =0;
		
		PreparedStatement pstmt =null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Order> selectOrderList(Connection conn, PageInfo pi) {
		
		ArrayList<Order> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOrderList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow =pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
		
				list.add(new Order(rset.getString("ORDER_ONO")
														,rset.getInt("ORDER_NO")
														,rset.getDate("ORDER_DATE")
														,rset.getString("USER_ID")
														,rset.getString("PRO_NAME")
														,rset.getInt("PRO_PRICE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}
