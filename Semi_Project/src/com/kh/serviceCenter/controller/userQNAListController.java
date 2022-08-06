package com.kh.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member_2.model.vo.MemberUser;
import com.kh.serviceCenter.model.service.ScService;
import com.kh.serviceCenter.model.vo.QNA;

/**
 * Servlet implementation class userQNAListController
 */
@WebServlet("/userQNAList.sc")
public class userQNAListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userQNAListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			MemberUser m = (MemberUser)session.getAttribute("loginUser");
			String userId = m.getUserId();
			ArrayList<QNA> qList = new ScService().selectUserQNA(userId);
			request.setAttribute("qList", qList);
			request.getRequestDispatcher("/views/service/userQNA.jsp").forward(request, response);
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
