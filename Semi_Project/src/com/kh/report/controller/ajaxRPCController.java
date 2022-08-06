package com.kh.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.memManage.model.vo.Member;
import com.kh.report.model.service.reportService;

/**
 * Servlet implementation class ajaxRPCController
 */
@WebServlet("/ajaxRPC.re")
public class ajaxRPCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxRPCController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = String.valueOf(request.getParameter("userId"));
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		if(!userId.equals("null")) {
			int result = new reportService().ajaxIncreaseRPC(userId);
			if(result>0) {
				int result1 = new reportService().completeReport(rno);
				if(result1>0) {
					int RPC = new reportService().selectRPC(userId);
					if(RPC>0) {
						if(RPC>=5) {
							new reportService().banUser(userId);
						}else {
							new reportService().banUpdate(userId,RPC);
						}
						}
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().print(1);

				}
			}
		}
		if(userId.equals("null")) {
			System.out.println(rno);
			int result1 = new reportService().completeReport(rno);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(1);
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
