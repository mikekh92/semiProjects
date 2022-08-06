package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.model.service.ReviewService;

/**
 * Servlet implementation class reviewUpdateController
 */
@WebServlet("/update.ro")
public class reviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewUpdateController() {
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
			
			int result=new ReviewService().updateReview(reviewNo,reviewAnswer);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "리뷰답변수정 완료");
				response.sendRedirect(request.getContextPath()+"/detail.ro?rno="+reviewNo);
				
			}else {
				request.setAttribute("errorMsg", "리뷰답변 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
