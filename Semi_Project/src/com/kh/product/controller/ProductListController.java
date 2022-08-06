package com.kh.product.controller;

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

/**
 * Servlet implementation class ProductListView
 */
@WebServlet("/list.pd")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount; //현재 총 게시글 개수
		int currentPage=1; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit; //페이지 하단에 보이는 페이지 페이징 최대 개수
		int boardLimit; //한 페이지에서 보여질 게시글 개수
		
		int maxPage; //가장 마지막 페이지가 몇번페이지인지 (총 페이지수)
		int startPage; //페이지 하단에 보여질 페이징 시작 수 
		int endPage; //페이지 하단에 보여질 페이징 끝 수 
		
		listCount = new ProductService().selectListCount();
		if(request.getParameter("cpage")!=null)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		pageLimit = 5;
		
		boardLimit = 10; 
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1)/pageLimit * pageLimit+1;
		
		// startPage=1  pageLimit=5 endPage=5
		// startPage=6 pageLimit=5 endPage=10 
		// startPage=11 pageLimit=5 endPage=15 
		// startPage=16 pageLimit=5 endPage=20
		
		endPage = startPage+pageLimit-1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		ArrayList<Product> list= new ProductService().selectList(pi);
		request.setAttribute("adCate", 1);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/admin/product/productHome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
