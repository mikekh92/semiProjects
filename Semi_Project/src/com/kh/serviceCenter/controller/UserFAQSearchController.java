package com.kh.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageInfo;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;
import com.kh.serviceCenter.model.service.ScService;
import com.kh.serviceCenter.model.vo.FAQ;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search.fq")
public class UserFAQSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFAQSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int search = Integer.parseInt(request.getParameter("search"));
		String scContent = request.getParameter("scContent");
		System.out.println(search);
		System.out.println(scContent);
		int listCount; //현재 총 게시글 개수
		int currentPage=1; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit; //페이지 하단에 보이는 페이지 페이징 최대 개수
		int boardLimit; //한 페이지에서 보여질 게시글 개수
		
		int maxPage; //가장 마지막 페이지가 몇번페이지인지 (총 페이지수)
		int startPage; //페이지 하단에 보여질 페이징 시작 수 
		int endPage; //페이지 하단에 보여질 페이징 끝 수 
		
		listCount = new ScService().UserSearchFAQCount(search,scContent);
		if(request.getParameter("cpage")!=null)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		pageLimit = 5;
		
		boardLimit = 10; 
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1)/pageLimit * pageLimit+1;
		
		endPage = startPage+pageLimit-1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
			
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		ArrayList<FAQ> list = new ArrayList<>();
		
		if(search==1) {			
			list= new ScService().selectSearchTitleList(pi,scContent);
		}else {
			list= new ScService().selectSearchContentList(pi,scContent);
		}
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("searchPd", scContent);
		request.setAttribute("search", search);
		request.setAttribute("scContent", scContent);
		request.getRequestDispatcher("/views/FAQ/userSearchFAQ.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
