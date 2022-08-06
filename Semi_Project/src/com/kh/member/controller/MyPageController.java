package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Address;
import com.kh.member_2.model.vo.MemberUser;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 이용해주세요.");
			
			response.sendRedirect("/Semi/views/common/login.jsp");
			
		}else{
			
			MemberUser m = (MemberUser)session.getAttribute("loginUser");
			
			Address a = new MemberService().SelectAddress(m.getUserId());
			
			
			System.out.println(m.getUserId());
			System.out.println(a);
			
			request.setAttribute("AddressPw",a);
			
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
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
