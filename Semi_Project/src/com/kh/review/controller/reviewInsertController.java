package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class reviewInsertController
 */
@WebServlet("/insert.ro")
public class reviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int reviewNo =Integer.parseInt(request.getParameter("reviewNo"));
		String reviewAnswer=request.getParameter("reviewanswer");
		
		Review r = new Review();
		r.setReviewAnswer(reviewAnswer);
		r.setReviewNo(reviewNo);
		int result = new ReviewService().insertReviewAnswer(r);
		
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg","글번호"+ reviewNo+"번"+" 리뷰답변등록 완료");
			response.sendRedirect(request.getContextPath()+"/list.ro?cpage=1");
		}else {
			request.getSession().setAttribute("alertMsg", "리뷰답변등록 실패");
			response.sendRedirect(request.getContextPath()+"/list.ro?cpage=1");
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
