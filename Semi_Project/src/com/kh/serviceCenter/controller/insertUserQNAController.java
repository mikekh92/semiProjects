package com.kh.serviceCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.serviceCenter.model.service.ScService;
import com.kh.serviceCenter.model.vo.QNA;

/**
 * Servlet implementation class insertUserQNAController
 */
@WebServlet("/insertUserQNA.sc")
public class insertUserQNAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertUserQNAController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String qnaId = request.getParameter("userId");
		String qnaCate = request.getParameter("qnaCate");
		String qnaTitle = request.getParameter("qnaTitle");
		String qnaContent = request.getParameter("qnaContent");
		
		QNA q = new QNA(qnaId, qnaCate, qnaTitle, qnaContent);
		
		int result = new ScService().insertUserQNA(q);
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "작성이 성공적으로 완료되었습니다.");
			response.sendRedirect("/Semi/userQNAList.sc");
		}
		else {
			session.setAttribute("alertMsg", "작성에 실패하였습니다 잠시 후 다시 시도해주세요.");
			response.sendRedirect("/Semi/userQNAList.sc");
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
