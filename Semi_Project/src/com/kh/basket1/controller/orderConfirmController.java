package com.kh.basket1.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.basket1.model.service.basket1Service;
import com.kh.basket1.model.vo.Basket;

/**
 * Servlet implementation class orderConfirmController
 */
@WebServlet("/orderCon.or")
public class orderConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderConfirmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("order"));
		ArrayList<Basket> baList = new basket1Service().selectbasket1(userNo);
		new basket1Service().insertOrder1(baList,userNo);
		new basket1Service().deleteBasket1(userNo);
		
		HttpSession session = request.getSession();
		session.setAttribute("alertMsg", "주문이 완료되었습니다.");
		response.sendRedirect("/Semi/views/semi/main.jsp");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
