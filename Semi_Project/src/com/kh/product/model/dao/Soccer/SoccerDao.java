package com.kh.product.model.dao.Soccer;
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

public class SoccerDao {
	
	private Properties prop = new Properties();
	
	public SoccerDao() {
		String fileName = SoccerDao.class.getResource("/db/product/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Product> SoccerProduct(Connection conn, PageInfo pi) {
		
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectsoccer");
		
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
	
	public ArrayList<Product> SoccertpProduct(Connection conn, PageInfo pi) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selecttpsoccer");
		
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
	
	public ArrayList<Product> SoccermdProduct(Connection conn, PageInfo pi) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectmdsoccer");
		
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
	
	public ArrayList<Product> SoccerbtProduct(Connection conn, PageInfo pi) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectbtsoccer");
		
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
//	Soccer Count
public int SoccerCount(Connection conn) {
		
		int listCount = 0; 
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql= prop.getProperty("selectSoccerCount");
		
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


public int SoccertpCount(Connection conn) {
	
	int listCount = 0; 
	
	PreparedStatement pstmt = null;
	
	ResultSet rset=null;
	
	String sql= prop.getProperty("selectSoccertpCount");
	
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
public int SoccermdCount(Connection conn) {
	
	int listCount = 0; 
	
	PreparedStatement pstmt = null;
	
	ResultSet rset=null;
	
	String sql= prop.getProperty("selectSoccermdCount");
	
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
public int SoccerbtCount(Connection conn) {
	
	int listCount = 0; 
	
	PreparedStatement pstmt = null;
	
	ResultSet rset=null;
	
	String sql= prop.getProperty("selectSoccerbtCount");
	
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



}

