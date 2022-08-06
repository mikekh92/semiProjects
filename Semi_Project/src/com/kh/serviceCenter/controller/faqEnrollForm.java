package com.kh.serviceCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.serviceCenter.model.vo.FAQ;

/**
 * Servlet implementation class faqEnrollForm
 */
@WebServlet("/faqEnroll.sc")
public class faqEnrollForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faqEnrollForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int faqNo = Integer.parseInt(request.getParameter("faqNo"));
		String faqCate = request.getParameter("faqCate");
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");
		FAQ f = new FAQ(faqNo, faqCate, faqTitle, faqContent);
		request.setAttribute("faq", f);
		request.getRequestDispatcher("/views/admin/serviceCenter/FAQEnroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
