package com.kh.memManage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageInfo;
import com.kh.memManage.model.service.memManageService;
import com.kh.memManage.model.vo.Member;

/**
 * Servlet implementation class memManageSearchController
 */
@WebServlet("/searchUser.mm")
public class memManageSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memManageSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userCate = request.getParameter("select_user_cate");
		String searchUser = request.getParameter("search_user");
		int listCount = 0;
		listCount = new memManageService().searchUserCount(userCate, searchUser);
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
		ArrayList<Member> mList = new memManageService().searchUser(userCate, searchUser , pi);
		request.setAttribute("adCate",7);
		request.setAttribute("pi",pi);
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("/views/admin/memManage/memManage_search.jsp").forward(request, response);
		
		
		


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
