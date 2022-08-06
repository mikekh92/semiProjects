package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageInfo;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSearchController
 */
@WebServlet("/search.no")
public class NoticeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		String firstSelect=request.getParameter("firstSelect");
		String secondSelect=request.getParameter("secondSelect");
//		System.out.println(firstSelect);
//		System.out.println(secondSelect);
		listCount = new NoticeService().selectSearchingCount(firstSelect,secondSelect);
		currentPage=Integer.parseInt(request.getParameter("cpage"));
//		System.out.println(listCount);
//		System.out.println(currentPage);
//		currentPage=1;
		pageLimit =10;
		boardLimit=10; //Integer.parseInt(request.getParameter("selectNumber"));
		maxPage=(int)(Math.ceil((double)listCount/boardLimit));
		startPage=(currentPage-1)/pageLimit*pageLimit+1;
		endPage=startPage+pageLimit-1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
//		
//		System.out.println(startPage + "startPage값");
//		System.out.println(endPage + "endPage값");
//		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
//		
//		System.out.println(firstSelect + "firstSelect값");
//		System.out.println(secondSelect + "secondSelect값");
//		
		ArrayList <Notice> list = new NoticeService().searchTitle(firstSelect,secondSelect,pi);
//		System.out.println(list);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("firstSelect", firstSelect);
		request.setAttribute("secondSelect", secondSelect);
		
		//request.getSession().setAttribute("firstSelect", firstSelect);
		//request.getSession().setAttribute("secondSelect", secondSelect);
		
		
//		for(int i=0; i<3; i++) {
//			System.out.println(list.get(i).getNoticeContent());
//			System.out.println(list.get(i).getNoticeWriter());
//			System.out.println(list.get(i).getNoticeNo());
//		}
//		
		request.getRequestDispatcher("views/admin/notice/noticeListSearchView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
