package com.kh.serviceCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.serviceCenter.model.service.ScService;
import com.kh.serviceCenter.model.vo.FAQ;

/**
 * Servlet implementation class faqInsertController
 */
@WebServlet("/faqInsert.sc")
public class faqInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faqInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int faqNo=0;
		if(request.getParameter("faqNo")!=null) faqNo = Integer.parseInt(request.getParameter("faqNo"));
		String faqCate = request.getParameter("faqCate");
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");
		FAQ faq = new FAQ();
		if(faqNo == 0) {
			faq = new FAQ(faqCate,faqTitle,faqContent);
			int result = new ScService().insertFAQ(faq);
			if(result>0)
				response.sendRedirect("/Semi/ScList.sc?cpage=1");
						
			
		}else {
			faq = new FAQ(faqNo, faqCate, faqTitle, faqContent);
			int result = new ScService().updateFAQ(faq);
			if(result>0)
				response.sendRedirect(request.getContextPath()+"/ScList.sc?cpage=1");
			
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
