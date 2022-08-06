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

import com.kh.product.model.vo.Product;

public class detailDao {
	
	private Properties prop = new Properties();
	
	public detailDao() {
		String fileName = detailDao.class.getResource("/db/product/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> detailselect(Connection conn, int pc) {
		//SELECT문 - > ResultSet 객체 (여러 행)
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("detailselect");
		System.out.println(pc);
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, pc);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRO_NO")
									,rset.getString("PRO_NAME")
									,rset.getString("PRO_IMAGE")
									,rset.getString("PRO_MAKER")
									,rset.getString("PRO_DES")
									,rset.getInt("PRO_PRICE")
									,rset.getInt("PRO_AMOUNT")));
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
