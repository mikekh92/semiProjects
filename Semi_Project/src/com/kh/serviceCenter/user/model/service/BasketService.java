package com.kh.serviceCenter.user.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.serviceCenter.user.model.dao.BasketDao;
import com.kh.serviceCenter.user.model.vo.Basket;

public class BasketService {

	public ArrayList<Basket> selectBaskets(int userNo) {
		Connection conn = getConnection();
		ArrayList<Basket> list = new BasketDao().selectBaskets(conn, userNo);
		close(conn);
		return list;
	}

}
