package com.kh.basket1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.basket1.model.service.basket1Service;
import com.kh.basket1.model.vo.Basket;
import com.kh.member_2.model.vo.MemberUser;

/**
 * Servlet implementation class basket1ListController
 */
@WebServlet("/Basket1.ba")
public class basket1ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public basket1ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userNo=0;
		if(request.getSession().getAttribute("loginUser")!=null) {
			MemberUser m = (MemberUser)request.getSession().getAttribute("loginUser");
			userNo = m.getUserNo();
			ArrayList<Basket> baList = new basket1Service().selectbasket1(userNo);
			if(baList!=null) {
			request.setAttribute("baList", baList);
			request.getRequestDispatcher("/views/basket1/basket1.jsp").forward(request, response);
			}else {
			}
		}else {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다. 로그인 후 이용해주세요");
			response.sendRedirect("/Semi/views/common/login.jsp");
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
