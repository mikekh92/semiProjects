package com.kh.detail.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.detail.model.vo.Basket;
import com.kh.serviceCenter.model.dao.ScDao;

public class BasketDao {
	Properties prop = new Properties();
	public BasketDao() {
		String fileName = ScDao.class.getResource("/db/ServiceCenter/serviceCenter-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Basket> selectBaskets(Connection conn) {
		ResultSet rset = null;
		ArrayList<Basket> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userBaskets");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Basket(rset.getInt("BASKET_NO"),
									rset.getInt("USER_NO"),
									rset.getInt("PRO_NO"),
									rset.getInt("PAY_ORDERNO")
									));
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
	public int insertBaskets(Connection conn, int pc, int lo, int po) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBasket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lo);
			pstmt.setInt(2, pc);
			pstmt.setInt(3, po);

			
		result =pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
