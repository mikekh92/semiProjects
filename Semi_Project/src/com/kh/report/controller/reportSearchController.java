package com.kh.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.PageInfo;
import com.kh.report.model.service.reportService;
import com.kh.report.model.vo.Report;

/**
 * Servlet implementation class reportSearchController
 */
@WebServlet("/searchReport.re")
public class reportSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String reportCate = request.getParameter("select_report_cate");
		String searchUser = request.getParameter("search_user");
		
		int listCount = 0;
		listCount = new reportService().searchReportCount(reportCate, searchUser);
		int currentPage =1;
		if(request.getParameter("cpage")!=null)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		int pageLimit = 5;
		int boardLimit = 10;
		int maxPage = (listCount/boardLimit) + ((listCount % boardLimit != 0) ? 1 : 0);
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage+pageLimit-1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage, endPage);
		ArrayList<Report> rList = new reportService().searchReport(reportCate, searchUser , pi);

		request.setAttribute("reportCate", reportCate);
		request.setAttribute("searchUser", searchUser);
		request.setAttribute("adCate",8);
		request.setAttribute("pi",pi);
		request.setAttribute("rList", rList);
		
		request.getRequestDispatcher("/views/admin/memManage/report_search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
