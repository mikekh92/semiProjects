package com.kh.member_2.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member_2.model.service.MemberUserService;
import com.kh.member_2.model.vo.Address;
import com.kh.member_2.model.vo.MemberUser;

/**
 * Servlet implementation class newMemberUserController
 */
@WebServlet("/newMemberUser.lo")
public class newMemberUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newMemberUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int postcode = Integer.parseInt(request.getParameter("postcode"));
		String roadAddress = request.getParameter("roadAddress");
		String jibunAddress = request.getParameter("jibunAddress");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		String userBirthS = request.getParameter("userBirth");
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//		Date userBirthD = fm.parse(userBirthS);
		
		Date userBirth = Date.valueOf(userBirthS);

		String gender = request.getParameter("gender");
		
		MemberUser mu = new MemberUser(userId,userPw,userName,userBirth,gender,email,phone);
		Address ar = new Address(userId, postcode, roadAddress, jibunAddress, detailAddress, extraAddress);
		HttpSession session = request.getSession();
		int result = new MemberUserService().insertMemberUser(mu);
		if(result>0) {
			result = new MemberUserService().insertAddress(ar);
			if(result>0) {
				session.setAttribute("alertMsg", "회원가입이 성공적으로 완료되었습니다.");
				response.sendRedirect("/Semi/views/semi/main.jsp");
			}
		}else {
			
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
