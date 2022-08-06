package com.kh.basket1.model.dao;

import static com.kh.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.kh.basket1.model.vo.Basket;

public class basketDao {
	Properties prop = new Properties();
	
	public basketDao() {
		String fileName = basketDao.class.getResource("/db/basket1/basket1-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Basket> selectbasket1(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Basket> baList = new ArrayList<Basket>();
		String sql = prop.getProperty("selectBasket1List");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				baList.add(new Basket(rset.getInt("PRO_NO"),
						rset.getString("PRO_NAME"),
						rset.getInt("PRO_PRICE"),
						rset.getInt("PAY_ORDERNO")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return baList;
	}


	public int insertOrder1(Connection conn, ArrayList<Basket> baList, int userNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 1;
		String sql = prop.getProperty("checkOrder");
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println("currentTime"+currentTime);
		int ranNum=0;
		String orderoNo = "";
		
		try {
			while(result!=0) {
				ranNum = (int)(Math.random()*90000 + 10000);
				orderoNo= currentTime+userNo+ranNum;
				System.out.println("orderoNo"+orderoNo);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, orderoNo);
				rset = pstmt.executeQuery();
				if(rset.next());
				result = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = 1;
		sql = prop.getProperty("insertOrder");
		
		try {
			for(Basket b : baList) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				pstmt.setString(2, orderoNo);
				pstmt.setInt(3, b.getProNo());
				pstmt.setInt(4, b.getPayOrderNo());
				pstmt.setInt(5, b.getProPrice());

				result = result * pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}


	public int deleteBasket1(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteBasket1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int confirmBasket(Connection conn, int[] basketY, int[] orderNo) {
		PreparedStatement pstmt = null;
		int result = 1;
		String sql = prop.getProperty("confirmBasket");
		
		try {
			for(int i=0;i<basketY.length;i++) {
				if(basketY[i]==0) continue;
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, orderNo[i]);
				pstmt.setInt(2, basketY[i]);

				result = result * pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int resetBasket(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("resetBasket");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertBuy(Connection conn, int pc, int lo, int po) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertBuy");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lo);
			pstmt.setInt(2, pc);
			pstmt.setInt(3, po);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
