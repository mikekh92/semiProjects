package com.kh.basket1.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.basket1.model.dao.basketDao;
import com.kh.basket1.model.vo.Basket;

public class basket1Service {

	public ArrayList<Basket> selectbasket1(int userNo) {
		Connection conn = getConnection();
		
		ArrayList<Basket> baList = new basketDao().selectbasket1(conn, userNo);
		
		close(conn);
		
		return baList;
		
	}

	public void insertOrder1(ArrayList<Basket> baList, int userNo) {
		Connection conn = getConnection();
		
		int result = new basketDao().insertOrder1(conn, baList, userNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

	public void deleteBasket1(int userNo) {
		Connection conn = getConnection();
		
		int result = new basketDao().deleteBasket1(conn, userNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		
	}
	
	public void confirmBasket(int[] basketY, int[] orderNo) {
		Connection conn = getConnection();
		
		int result = new basketDao().confirmBasket(conn, basketY, orderNo);
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

	public void resetBasket(int userNo) {
		Connection conn = getConnection();
		
		int result = new basketDao().resetBasket(conn, userNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

	public void insertBuy(int pc, int lo, int po) {
		Connection conn = getConnection();
		
		int result = new basketDao().insertBuy(conn, pc, lo, po);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

}


