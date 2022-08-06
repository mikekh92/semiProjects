package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member_2.model.vo.MemberUser;
import com.kh.review.model.service.ReviewServiceUser;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insertReview.ro")
public class ReviewInsertControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertControllerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String reviewTitle = request.getParameter("insertReviewTitle");
		String reviewContent = request.getParameter("insertReviewContent");
		int productNo =Integer.parseInt(request.getParameter("productNo"));
		if(request.getSession().getAttribute("loginUser")==null) {
			 request.getSession().setAttribute("alertMsg", "로그인 후 이용해주세요");
			 response.sendRedirect("/Semi/views/common/login.jsp");
		}else {
			int userNo = ((MemberUser)request.getSession().getAttribute("loginUser")).getUserNo();
			Review r = new Review();
			
			r.setReviewContent(reviewContent);
			r.setReviewTitle(reviewTitle);
			r.setProNo(productNo);
			r.setUserNo(userNo); 
			
			
			int result=new ReviewServiceUser().insertReview(r);
			
			response.getWriter().print(result);
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
