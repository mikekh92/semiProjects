package com.kh.product.model.dao.Boling;
import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.PageInfo;
import com.kh.product.model.vo.Product;

public class BolingDao {
	
	private Properties prop = new Properties();
	
	public BolingDao() {
		String fileName = BolingDao.class.getResource("/db/product/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Product> BolingProduct(Connection conn, PageInfo pi) {
		
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectboling");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRO_NO")
									,rset.getString("PRO_NAME")
									,rset.getInt("PRO_PRICE")
									,rset.getString("PRO_IMAGE")
									,rset.getInt("CATE_BNO")
									,rset.getInt("CATE_SNO")));
			}
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
public int BolingCount(Connection conn) {
		
		int listCount = 0; 
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql= prop.getProperty("selectBolingCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT"); //나올 행이 하나뿐이기 때문에 while문이 아닌 if문 사용
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}



public int BolingtpCount(Connection conn, int cateNo) {
	int listCount = 0; 
	
	PreparedStatement pstmt = null;
	
	ResultSet rset=null;
	
	String sql= prop.getProperty("selectBolingtpCount");
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cateNo);
		rset=pstmt.executeQuery();
		
		if(rset.next()) {
			listCount = rset.getInt("COUNT"); //나올 행이 하나뿐이기 때문에 while문이 아닌 if문 사용
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
	
	return listCount;
}



public ArrayList<Product> BolingtpProduct(Connection conn, PageInfo pitp, int cateNo) {
	ArrayList<Product> listtp = new ArrayList<>();
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	String sql = prop.getProperty("selecttpboling");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		int startRow = (pitp.getCurrentPage()-1) * pitp.getBoardLimit() +1;
		int endRow = pitp.getCurrentPage() * pitp.getBoardLimit();
		
		pstmt.setInt(1, cateNo);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, endRow);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			listtp.add(new Product(rset.getInt("PRO_NO")
								,rset.getString("PRO_NAME")
								,rset.getInt("PRO_PRICE")
								,rset.getString("PRO_IMAGE")
								,rset.getInt("CATE_BNO")
								,rset.getInt("CATE_SNO")));
		}
		System.out.println(listtp);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
	return listtp;
}
}

