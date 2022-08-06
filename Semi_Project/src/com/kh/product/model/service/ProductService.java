package com.kh.product.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.product.model.vo.Attachment;
import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.vo.Category;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.sCategory;

public class ProductService {

	public ArrayList<Category> selectCategoryList() {
		Connection conn=getConnection();
		
		ArrayList<Category> list = new ProductDao().selectCategoryList(conn);
		close(conn);
		
		return list;
		
	}

	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProductDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Product> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectList(conn,pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<sCategory> selectSCategoryList(int bcg) {
		Connection conn = getConnection();
		
		ArrayList<sCategory> list = new ProductDao().selectSCategoryList(conn,bcg);
		
		close(conn);
		
		return list;
		
	}

	public int insertProduct(Product p, ArrayList<com.kh.product.model.vo.Attachment> list) {
		Connection conn = getConnection();
		
		int result1 = new ProductDao().insertProduct(conn, p);
		
		int result2 = new ProductDao().insertAttachmentList(conn, list);
		
		if(result1>0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
		
	}

	public int deleteProduct(int[] proNo) {
		Connection conn = getConnection();
		
		int result = new ProductDao().deleteProduct(conn,proNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Product selectdetail(int proNo) {
		Connection conn = getConnection();
		
		Product p = new ProductDao().selectdetail(conn,proNo);
		
		close(conn);
		
		return p;
		
	}

	public ArrayList<Attachment> selectAttachment(int proNo) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new ProductDao().selectAttachment(conn,proNo);
		close(conn);
		return list;
	}

	public Category selectBigCategory(int cateBno) {
		Connection conn = getConnection();
		Category c = new ProductDao().selectBigCategory(conn,cateBno);
		close(conn);
		return c;
	}

	public Category selectSmallCategory(int cateSno) {
		Connection conn = getConnection();
		Category c = new ProductDao().selectSmallCategory(conn,cateSno);
		close(conn);
		return c;
	}

	public int updateProduct(Product p) {
		Connection conn = getConnection();
		int result = new ProductDao().updateProduct(conn,p);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int dropProduct(int proNo, int count) {
		Connection conn = getConnection();
		int result1 = new ProductDao().dropAttachment(conn,proNo,count);
		
		int	result2 = new ProductDao().dropProduct(conn,proNo);

		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1+result2;
	}

	public int reSellProduct(int[] proNo) {
		Connection conn = getConnection();
		
		int result = new ProductDao().reSellProduct(conn,proNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int selectSearchListCount(String searchPd) {
		Connection conn = getConnection();
		
		int listCount = new ProductDao().selectSearchListCount(conn,searchPd);
		
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Product> selectSearchList(PageInfo pi, String searchPd) {
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectSearchList(conn,pi,searchPd);
		
		close(conn);
		
		return list;
	}



	public void CrawlingInsertPro(ArrayList<Product> pList) {
		Connection conn = getConnection();
		
		int result = new ProductDao().CrawlingInsertPro(conn, pList);
		
		if(result>0) commit(conn);
		rollback(conn);
		
		close(conn);
		
	}
	
	
}
