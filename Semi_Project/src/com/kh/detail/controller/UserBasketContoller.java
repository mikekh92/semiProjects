package com.kh.detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.detail.model.service.BasketService;
import com.kh.detail.model.vo.Basket;



/**
 * Servlet implementation class UserBasketContoller
 */
@WebServlet("/userBaskett.bk")
public class UserBasketContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBasketContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		int pc = Integer.parseInt(request.getParameter("pc"));
		int lo = Integer.parseInt(request.getParameter("lo"));
		int po = Integer.parseInt(request.getParameter("po"));
	
		if(request.getSession().getAttribute("loginUser")==null) {
			request.getSession().setAttribute("alertMsg", "로그인 후 이용해주세요");
			response.sendRedirect("/Semi/views/common/login.jsp");
		}else {
			int result = new BasketService().insertBaskets(pc,lo,po);
			request.getSession().setAttribute("alertMsg", "장바구니 등록이 완료되었습니다.");
			response.sendRedirect("/Semi/userBasket.bk");
		}

		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
