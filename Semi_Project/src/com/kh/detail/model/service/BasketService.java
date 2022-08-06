package com.kh.detail.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.detail.model.dao.BasketDao;
import com.kh.detail.model.vo.Basket;



public class BasketService {

	public ArrayList<Basket> selectBaskets() {
		Connection conn = getConnection();
		ArrayList<Basket> list = new BasketDao().selectBaskets(conn);
		close(conn);
		return list;
	}

	public int insertBaskets(int pc, int lo, int po) {
		
		Connection conn = getConnection();
		int result= new BasketDao().insertBaskets(conn,pc,lo,po);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}



}
