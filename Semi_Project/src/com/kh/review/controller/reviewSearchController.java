package com.kh.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageInfo;

import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class reviewSearchController
 */
@WebServlet("/search.ro")
public class reviewSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewSearchController() {
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
		listCount = new ReviewService().selectSearchingCount(firstSelect,secondSelect);
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
		ArrayList <Review> list = new ReviewService().searchValues(firstSelect,secondSelect,pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("firstSelect", firstSelect);
		request.setAttribute("secondSelect", secondSelect);
	
		request.getRequestDispatcher("views/admin/review/reviewListSearchView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
