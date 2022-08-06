package com.kh.detail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.basket1.model.service.basket1Service;
import com.kh.member_2.model.vo.MemberUser;

/**
 * Servlet implementation class purchaseController
 */
@WebServlet("/purchase.pr")
public class purchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseController() {
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
		int price = Integer.parseInt(request.getParameter("price"));
		
		if(request.getSession().getAttribute("loginUser")==null) {
			request.getSession().setAttribute("alertMsg","로그인 후 이용해주세요");
			response.sendRedirect("/Semi/views/common/login.jsp");
		}else {
			
			new basket1Service().insertBuy(pc,lo,po);
			
			MemberUser loginUser = (MemberUser)request.getSession().getAttribute("loginUser");
			request.setAttribute("sw", 1);
			request.setAttribute("name",loginUser.getUserName());
			request.setAttribute("email",loginUser.getEmail());
			request.setAttribute("phone",loginUser.getPhone());
			request.setAttribute("address","부평구 충선로");
			request.setAttribute("totalPrice",price);
			request.getRequestDispatcher("/views/payment/kakao.jsp").forward(request, response);
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
