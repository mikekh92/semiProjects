package com.kh.serviceCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.serviceCenter.model.service.ScService;
import com.kh.serviceCenter.model.vo.QNA;

/**
 * Servlet implementation class ajaxQNAModalController
 */
@WebServlet("/ajaxQNAModal.sc")
public class ajaxQNAModalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxQNAModalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnaNo =Integer.parseInt(request.getParameter("qno"));
		
		QNA q = new ScService().ajaxSelectQNA(qnaNo);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(q,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
