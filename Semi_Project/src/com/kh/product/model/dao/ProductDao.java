package com.kh.product.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.PageInfo;
import com.kh.product.model.vo.Attachment;
import com.kh.product.model.vo.Category;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.sCategory;

public class ProductDao {
	

	private Properties prop = new Properties();
	
	public ProductDao() {
		String fileName = ProductDao.class.getResource("/db/product/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public ArrayList<Category> selectCategoryList(Connection conn) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		ArrayList<Category> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Category(rset.getInt("CATE_NO"),
									  rset.getString("CATE_NAME")));
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
	
	public ArrayList<sCategory> selectSCategoryList(Connection conn, int bcg) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		ArrayList<sCategory> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectsCategory");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bcg);
			pstmt.setInt(2, bcg);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new sCategory(rset.getInt("CATE_NO"),
									  rset.getString("CATE_NAME")));
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

	public int selectListCount(Connection conn) {
		int listCount=0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT");
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
		
	public ArrayList<Product> selectList(Connection conn, PageInfo pi) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//boardLimit = 10; 10개씩 
			//currentPage= 1 => 시작값 1 끝 10
			//currentPage= 2 => 시작값 11 끝 20
			//currentPage= 3 => 시작값 21 끝 30
			
			//시작값 = (currentPage-1)*boardLimit + 1
			//끝값 = currntPage*boardLimit
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = pi.getCurrentPage()*pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
			list.add(new Product(rset.getInt("PRO_NO"),
								 rset.getString("PRO_NAME"),
								 rset.getString("PRO_CODE"),
								 rset.getString("PRO_MAKER"),
								 rset.getInt("PRO_PRICE"),
								 rset.getInt("PRO_AMOUNT"),
								 rset.getString("PRO_STATUS"),
								 rset.getString("SELL_STAT")));
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
	public int insertProduct(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, p.getProName());
			pstmt.setInt(2, p.getProPrice());
			pstmt.setString(3, p.getProCode());
			pstmt.setString(4, p.getProMaker());
			pstmt.setString(5, p.getProDes());
			pstmt.setInt(6, p.getCateBno());
			pstmt.setInt(7, p.getCateSno());
			pstmt.setString(8, p.getProSize());
			pstmt.setInt(9, p.getProAmount());
			pstmt.setInt(10, Integer.parseInt(p.getProLevel()));
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int insertAttachmentList(Connection conn, ArrayList<Attachment> list) {
		
		int result = 1;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			for(Attachment at : list) {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result *= pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteProduct(Connection conn, int[] proNo) {
		int result = 1;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<proNo.length;i++) {
				
				pstmt.setInt(1, proNo[i]);
				result*=pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}
	public Product selectdetail(Connection conn, int proNo) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectDetail");
		Product p = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, proNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				p=new Product(rset.getInt("PRO_NO"),
							  rset.getString("PRO_NAME"),
							  rset.getString("PRO_CODE"),
							  rset.getString("PRO_MAKER"),
							  rset.getString("PRO_DES"),
							  rset.getInt("CATE_BNO"),
							  rset.getInt("CATE_SNO"),
							  rset.getString("PRO_SIZE"),
							  rset.getInt("PRO_PRICE"),
							  rset.getInt("PRO_AMOUNT"),
							  rset.getString("LEVEL_NAME"),
							  rset.getString("PRO_STATUS"),
							  rset.getString("SELL_STAT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(conn);
		}return p;
	}
	public ArrayList<Attachment> selectAttachment(Connection conn, int proNo) {
		ArrayList<Attachment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachmentList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, proNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				list.add(at);
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
	public Category selectBigCategory(Connection conn, int cateBno) {
		Category c = new Category();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selecCategory");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cateBno);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				c.setCateNo(rset.getInt("CATE_NO"));
				c.setCateName(rset.getString("CATE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
		
	}
	public Category selectSmallCategory(Connection conn, int cateSno) {
		Category c = new Category();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selecCategory");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cateSno);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				c.setCateNo(rset.getInt("CATE_NO"));
				c.setCateName(rset.getString("CATE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}
	public int updateProduct(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, p.getProName());
			pstmt.setInt(2, p.getProPrice());
			pstmt.setString(3, p.getProCode());
			pstmt.setString(4, p.getProMaker());
			pstmt.setString(5, p.getProDes());
			pstmt.setInt(6, p.getCateBno());
			pstmt.setInt(7, p.getCateSno());
			pstmt.setString(8, p.getProSize());
			pstmt.setInt(9, p.getProAmount());
			pstmt.setInt(10, Integer.parseInt(p.getProLevel()));
			pstmt.setInt(11, p.getProNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	public int dropAttachment(Connection conn, int proNo, int count) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("dropAttachment");
		
		try {
			for(int i=0;i<count;i++) {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, proNo);
				result *= pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int dropProduct(Connection conn, int proNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("dropProduct");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, proNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int reSellProduct(Connection conn, int[] proNo) {
		int result = 1;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("reSellProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<proNo.length;i++) {
				
				pstmt.setInt(1, proNo[i]);
				result*=pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int selectSearchListCount(Connection conn,String searchPd) {
		int listCount=0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSearchListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchPd);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT");
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
	public ArrayList<Product> selectSearchList(Connection conn, PageInfo pi, String searchPd) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSearchList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//boardLimit = 10; 10개씩 
			//currentPage= 1 => 시작값 1 끝 10
			//currentPage= 2 => 시작값 11 끝 20
			//currentPage= 3 => 시작값 21 끝 30
			
			//시작값 = (currentPage-1)*boardLimit + 1
			//끝값 = currntPage*boardLimit
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setString(1, searchPd);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
			list.add(new Product(rset.getInt("PRO_NO"),
								 rset.getString("PRO_NAME"),
								 rset.getString("PRO_CODE"),
								 rset.getString("PRO_MAKER"),
								 rset.getInt("PRO_PRICE"),
								 rset.getInt("PRO_AMOUNT"),
								 rset.getString("PRO_STATUS"),
								 rset.getString("SELL_STAT")));
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
	public int CrawlingInsertPro(Connection conn, ArrayList<Product> pList) {
		PreparedStatement pstmt = null;
		int result = 1;
		String sql = prop.getProperty("CrawlingInsertPro");
		

			try {
				for(Product p : pList) {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, p.getProName());
				pstmt.setInt(2, p.getProPrice());
				pstmt.setString(3, p.getProImage());
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

}
