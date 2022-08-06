package com.kh.serviceCenter.user.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.serviceCenter.model.dao.ScDao;
import com.kh.serviceCenter.user.model.vo.Basket;

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
	public ArrayList<Basket> selectBaskets(Connection conn, int userNo) {
		ResultSet rset = null;
		ArrayList<Basket> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userBasket");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Basket(rset.getInt("BASKET_NO"),
									rset.getString("PRO_NAME"),
									rset.getString("PRO_IMAGE"),
									rset.getInt("PAY_ORDERNO"),
									rset.getInt("PRO_PRICE")));
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
